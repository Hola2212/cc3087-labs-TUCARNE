/*
 * Respuestas Ruta B:
 * 1. Al quitar el weight, la columna de texto solo ocupa el espacio necesario para su contenido. 
 *    Esto hace que la miniatura de la derecha se desplace hacia la izquierda y no se alinee al final 
 *    del contenedor, rompiendo la estructura de feed donde el texto ocupa el espacio sobrante.
 * 
 * 2. Recibe un Modifier para que el contenedor padre tenga control sobre el posicionamiento y 
 *    espaciado externo del componente. Si el margen estuviera fijo adentro, no podríamos 
 *    reutilizar el componente en pantallas que requieran diferentes márgenes o alineaciones.
 */
package com.example.lab05composefeed.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab05composefeed.data.ArticleRepository
import com.example.lab05composefeed.ui.components.FeedTabs
import com.example.lab05composefeed.ui.components.MediumArticle

@Preview(showBackground = true)
@Composable
fun FeedScreen (
    modifier: Modifier = Modifier
) {
    val articles = ArticleRepository.getList()

    var selectedTab by rememberSaveable { mutableStateOf("Para ti") }
    var searchQuery by rememberSaveable { mutableStateOf("")}
    var showShortReadsOnly by rememberSaveable { mutableStateOf(false) }

    val filteredArticles = articles.filter { article ->
        val matchesTab = when (selectedTab) {
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
        val matchesSearch = searchQuery.isBlank() ||
                article.title.contains(searchQuery, ignoreCase = true) ||
                article.name.contains(searchQuery, ignoreCase = true)
        val matchesLength = !showShortReadsOnly || article.readTime <= 5
        matchesTab && matchesSearch && matchesLength
    }
    Column(
        modifier = modifier
    ) {
        FeedTabs(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar por título o autor") }
        )

        Row {
            Switch(
                checked = showShortReadsOnly,
                onCheckedChange = { showShortReadsOnly = it }
            )
            Text("Solo lecturas cortas")
        }

        Row {
            Text("${filteredArticles.size} resultados")
            TextButton(onClick = { }) {
                Text("Aplaudir · 0")
            }
        }

        if (filteredArticles.isEmpty()) {
            Text("No se encontraron artículos")
            Text("Cambia la pestaña, la búsqueda o el filtro.")
        } else {
            filteredArticles.forEach { article ->
                MediumArticle(article)
            }
        }
    }
}

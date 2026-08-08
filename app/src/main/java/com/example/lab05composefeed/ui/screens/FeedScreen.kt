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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab05composefeed.data.ArticleRepository
import com.example.lab05composefeed.ui.components.MediumArticle
import com.example.lab05composefeed.ui.components.TabsSection
import com.example.lab05composefeed.ui.components.TopBar

@Preview(showBackground = true)
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    val articles = ArticleRepository.getList().toList()
    Column(
        modifier = modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TopBar()
        TabsSection()
        
        // Horizontal separator after tabs
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFEEEEEE))
        )
        
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            articles.forEachIndexed { index, article ->
                MediumArticle(article = article)
                
                // Separator between articles
                if (index < articles.size - 1) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color(0xFFEEEEEE))
                    )
                }
            }
        }
    }
}

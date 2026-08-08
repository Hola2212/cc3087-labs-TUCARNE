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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab05composefeed.data.ArticleRepository
import com.example.lab05composefeed.ui.components.MediumArticle

@Preview(showBackground = true)
@Composable
fun FeedScreen (
    modifier: Modifier = Modifier
) {
    val articles = ArticleRepository.getList()
    Column(
        modifier = modifier
    ) {
        Row() { }
        Row() { }
        articles.forEachIndexed { index, article ->
            MediumArticle(
                article
            )
        }
    }
}

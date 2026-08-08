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
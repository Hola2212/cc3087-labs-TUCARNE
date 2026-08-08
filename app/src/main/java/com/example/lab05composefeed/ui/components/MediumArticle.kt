package com.example.lab05composefeed.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05composefeed.model.Article
import com.example.lab05composefeed.ui.theme.GrayGeneralText


@Composable
fun MediumArticle (
    article: Article,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                //Article name
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color(article.circleColor))
                ) {

                }
                Text(
                    text = article.name,
                    color = GrayGeneralText
                )
            }
            Text(
                text = article.title,
                fontSize = 24.sp
            )
            Text(
                text = article.summary,
                textAlign = TextAlign.Justify
            )
            Text(
                text = "${article.readTime} min de lectura · ${article.date}"
            )
        }
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(article.squareColor))
        )
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MediumArticlePreview (article: String = "Ana Robles") {
    val title: String = "Por qué su primera app se siente lenta"
    val summary: String = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde."
    val readTime: Int = 5
    val date: String = "12 dic"
    Row() {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                //Article name
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                ) {

                }
                Text(
                    text = article,
                    color = GrayGeneralText
                )
            }
            Text(
                text = title,
                fontSize = 24.sp
            )
            Text(
                text = summary,
                textAlign = TextAlign.Justify
            )
            Text(
                text = "$readTime min de lectura · $date"
            )
        }
    }


    Box() {

    }
}*/
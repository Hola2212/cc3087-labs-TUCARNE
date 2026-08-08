package com.example.lab05composefeed.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05composefeed.model.Article

@Composable
fun MediumArticle(
    article: Article,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Author row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color(article.circleColor))
                )
                Text(
                    text = article.name,
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
            }
            
            // Title
            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            // Summary
            Text(
                text = article.summary,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Metadata
            Text(
                text = "${article.readTime} min de lectura · ${article.date}",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
        
        // Thumbnail
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
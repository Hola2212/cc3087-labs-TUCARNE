package com.example.lab05composefeed.data

import com.example.lab05composefeed.model.Article

object ArticleRepository {
    fun getList () = setOf<Article>(
        Article(
            name = "Gordon Ramsey",
            title = "Ya no hay buenos cocineros",
            summary = "Los cocineros ya no pueden manejar la cocina de forma correcta",
            readTime = 5,
            date = "05 may, 2024",
            circleColor = 0xFFda424f,
            squareColor = 0xFFffddba,
            isAuthorFollowed = true,
            isFeatured = false
        ),
        Article(
            name = "Maria Sierra",
            title = "Almuerzos en 5 minuto",
            summary = "Las personas cada vez tienden a cocinar menos. ¿Será por que no tienen tiempo?",
            readTime = 20,
            date = "15 mar, 2025",
            circleColor = 0xFF1598d3,
            squareColor = 0xFFf25b89,
            isAuthorFollowed = false,
            isFeatured = true
        ),
        Article(
            name = "Luis Chan",
            title = "Esta no es nuestra comida",
            summary = "La cultura americana ha comercializado nuestra cocina. Nuestra comida es más de lo que creen",
            readTime = 10,
            date = "01 dic, 2022",
            circleColor = 0xFF00d756,
            squareColor = 0xFFce7f22,
            isAuthorFollowed = true,
            isFeatured = true
        )
    )
}
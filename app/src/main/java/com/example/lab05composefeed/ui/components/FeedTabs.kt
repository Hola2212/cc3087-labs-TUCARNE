package com.example.lab05composefeed.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.lab05composefeed.ui.theme.GrayGeneralText

@Composable
fun FeedTabs(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf("Para ti", "Siguiendo", "Destacados")

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        tabs.forEach { tab ->
            val isSelected = tab == selectedTab
            Text(
                text = tab,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) GrayGeneralText else GrayGeneralText.copy(alpha = 0.5f),
                modifier = Modifier.clickable { onTabSelected(tab) }
            )
        }
    }
}
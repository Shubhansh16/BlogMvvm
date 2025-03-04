package com.example.blog.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun ShimmerEffect() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(80.dp)
            .placeholder(visible = true),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {}
}
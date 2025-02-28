package com.example.blog.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.blog.ui.components.BlogCard
import com.example.blog.ui.components.ShimmerEffect
import com.example.blog.viewmodel.BlogViewModel

@Composable
fun BlogListScreen(viewModel: BlogViewModel, onBlogClick: (String) -> Unit) {
    val lazyPagingItems = viewModel.blogs.collectAsLazyPagingItems()
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        if (lazyPagingItems.loadState.refresh is LoadState.Loading) {
            items(5) { ShimmerEffect() }
        } else {
            items(lazyPagingItems.itemCount) { index ->
                lazyPagingItems[index]?.let { blog ->
                    BlogCard(blog = blog, onBlogClick = onBlogClick)
                }
            }
        }
    }
}
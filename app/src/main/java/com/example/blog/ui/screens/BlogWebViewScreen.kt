package com.example.blog.ui.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun BlogWebView(url: String, onBack: () -> Unit) {
    BackHandler { onBack() }
    AndroidView(factory = { WebView(it).apply {
        webViewClient = WebViewClient()
        loadUrl(url)
    } })
}

//
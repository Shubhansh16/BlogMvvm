package com.example.blog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.blog.data.local.BlogDatabase
import com.example.blog.data.remote.BlogApiService
import com.example.blog.data.repository.BlogRepository
import com.example.blog.ui.screens.BlogListScreen
import com.example.blog.ui.screens.BlogWebView
import com.example.blog.ui.theme.BlogTheme
import com.example.blog.viewmodel.BlogViewModel
import com.example.blog.viewmodel.BlogViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, BlogDatabase::class.java, "blog_db").build()
        val api = Retrofit.Builder()
            .baseUrl("https://blog.vrid.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlogApiService::class.java)
        val repository = BlogRepository(db.blogDao(), api)
        val viewModel = ViewModelProvider(this, BlogViewModelFactory(repository)).get(BlogViewModel::class.java)

        setContent {
            var selectedUrl by remember { mutableStateOf<String?>(null) }
            if (selectedUrl == null) {
                BlogListScreen(viewModel) { selectedUrl = it }
            } else {
                BlogWebView(selectedUrl!!) { selectedUrl = null }
            }
        }
    }
}

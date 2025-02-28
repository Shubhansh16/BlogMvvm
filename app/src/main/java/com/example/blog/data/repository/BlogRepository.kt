package com.example.blog.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.blog.data.local.BlogDao
import com.example.blog.data.model.BlogPost
import com.example.blog.data.remote.BlogApiService
import com.example.blog.data.remote.BlogPagingSource

class BlogRepository(private val dao: BlogDao, private val api: BlogApiService) {
    fun getPagedBlogs(): Pager<Int, BlogPost> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { BlogPagingSource(api) }
        )
    }
}
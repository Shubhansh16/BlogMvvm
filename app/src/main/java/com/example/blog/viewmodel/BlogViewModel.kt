package com.example.blog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.blog.data.repository.BlogRepository

class BlogViewModel(private val repository: BlogRepository) : ViewModel() {
    val blogs = repository.getPagedBlogs().flow.cachedIn(viewModelScope)
}
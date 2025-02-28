package com.example.blog.data.model


data class BlogResponse(
    val id: Int,
    val title: Rendered,
    val link: String
)

data class Rendered(val rendered: String)
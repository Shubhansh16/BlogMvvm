package com.example.blog.data.remote

import com.example.blog.data.model.BlogResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApiService {
    @GET("wp-json/wp/v2/posts")
    suspend fun getBlogs(@Query("per_page") perPage: Int, @Query("page") page: Int): List<BlogResponse>
}
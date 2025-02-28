package com.example.blog.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.blog.data.model.BlogPost

class BlogPagingSource(private val api: BlogApiService) : PagingSource<Int, BlogPost>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BlogPost> {
        val page = params.key ?: 1
        return try {
            val response = api.getBlogs(perPage = 10, page = page).map { BlogPost(it.id, it.title.rendered, it.link) }
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, BlogPost>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
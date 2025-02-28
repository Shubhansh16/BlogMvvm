package com.example.blog.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blog.data.model.BlogPost

@Dao
interface BlogDao {
    @Query("SELECT * FROM blog_table")
    fun getAllBlogs(): PagingSource<Int, BlogPost>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(blogs: List<BlogPost>)

    @Query("DELETE FROM blog_table")
    suspend fun clearAll()
}

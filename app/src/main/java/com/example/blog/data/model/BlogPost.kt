package com.example.blog.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Data Model
@Entity(tableName = "blog_table")
data class BlogPost(
    @PrimaryKey val id: Int,
    val title: String,
    val link: String
)

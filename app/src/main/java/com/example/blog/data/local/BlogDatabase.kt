package com.example.blog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blog.data.model.BlogPost

@Database(entities = [BlogPost::class], version = 1)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun blogDao(): BlogDao
}
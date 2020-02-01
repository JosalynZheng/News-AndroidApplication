package com.cse438.tinnews.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.cse438.tinnews.common.NewsDao
import com.cse438.tinnews.retrofit.response.News



@Database(entities = [News::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao() : NewsDao
}
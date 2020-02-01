package com.cse438.tinnews

import android.app.Application
import android.arch.persistence.room.Room
import com.cse438.tinnews.database.AppDatabase
import com.facebook.stetho.Stetho

class TinApplication: Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "tin_db").build()
    }
}
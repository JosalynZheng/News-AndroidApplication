package com.cse438.tinnews.common

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.cse438.tinnews.retrofit.response.News
import io.reactivex.Flowable


@Dao
interface NewsDao {
    @Insert
    fun insertNews(news: News)

    @Query("SELECT * FROM news")
    fun getAll() : Flowable<List<News>>

    @Query("DELETE FROM news")
    fun deleteAllNews()

}
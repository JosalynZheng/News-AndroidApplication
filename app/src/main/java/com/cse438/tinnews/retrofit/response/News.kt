package com.cse438.tinnews.retrofit.response

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "news")
class News: Serializable {
    lateinit var author: String
    @NotNull
    @PrimaryKey
    lateinit var title: String
    lateinit var description: String
    lateinit var url: String
    @SerializedName("urlToImage")
    lateinit var image: String
    @SerializedName("publishedAt")
    lateinit var time: String
}
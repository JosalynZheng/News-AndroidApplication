package com.cse438.tinnews.retrofit.response

import com.google.gson.annotations.SerializedName
import java.util.*

class BaseResponse {

    lateinit var status: String
    var totalResult = 0
    @SerializedName("articles")
    lateinit var articles: List<News>


}
package com.cse438.tinnews.retrofit

import com.cse438.tinnews.retrofit.response.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*





interface NewsRequestApi {
    @GET("top-headlines")
    fun getNewsByCountry(@Query("country") country: String): Observable<BaseResponse>

}
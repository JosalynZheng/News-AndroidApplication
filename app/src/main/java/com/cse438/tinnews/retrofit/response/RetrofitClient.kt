package com.cse438.tinnews.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        val API = "d9024873f3a84a9db5e28b0ace2db36b"
        val BASE_URL = "https://newsapi.org/v2/"
        var instance: Retrofit? = null

        fun getMyInstance(): Retrofit {
            if (instance == null) {
                instance = Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create()).client(getHttpClient()).build()
            }
            return instance!!
        }

        fun getHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder().addInterceptor(NewsInterceptor()).connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS)
            return builder.build()
        }

        class NewsInterceptor : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val request = original.newBuilder().header("X-Api-Key", API).build()
                return chain.proceed(request)
            }
        }
    }
}
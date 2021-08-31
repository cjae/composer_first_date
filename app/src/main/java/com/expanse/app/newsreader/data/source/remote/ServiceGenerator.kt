package com.expanse.app.newsreader.data.source.remote

import com.expanse.app.newsreader.model.NewsResponse
import com.expanse.app.newsreader.utils.ServerUtils
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceGenerator {

    @GET("top-headlines")
    suspend fun getNews(@Query(ServerUtils.COUNTRY) country: String = "us",
                        @Query(ServerUtils.API_KEY) apiKey: String): NewsResponse
}
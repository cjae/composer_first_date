package com.expanse.app.newsreader.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @field:SerializedName("status") val status: String,
    @field:SerializedName("totalResults") val totalResults: Int,
    @field:SerializedName("articles") val results: List<NewsItem>,
    @field:SerializedName("message") val message: String
)
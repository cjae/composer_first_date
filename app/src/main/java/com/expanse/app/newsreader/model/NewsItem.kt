package com.expanse.app.newsreader.model

import com.google.gson.annotations.SerializedName

data class NewsItem(
    @field:SerializedName("author") val author: String?,
    @field:SerializedName("title") val title: String?,
    @field:SerializedName("description") val description: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("urlToImage") val urlToImage: String?,
    @field:SerializedName("publishedAt") val publishedAt: String?,
    @field:SerializedName("content") val content: String?
)
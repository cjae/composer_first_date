package com.expanse.app.newsreader.data.mappers

import com.expanse.app.newsreader.data.entities.NewsEntity
import com.expanse.app.newsreader.model.NewsItem
import javax.inject.Inject

class CacheMapper @Inject constructor() {

    fun mapToEntity(data: NewsItem): NewsEntity {
        return NewsEntity(
            author = data.author ?: "",
            title = data.title ?: "",
            description = data.description ?: "",
            url = data.url ?: "",
            urlToImage = data.urlToImage ?: "",
            publishedAt = data.publishedAt ?: "",
            content = data.content ?: ""
        )
    }
}
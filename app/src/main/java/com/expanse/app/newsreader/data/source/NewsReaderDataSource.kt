package com.expanse.app.newsreader.data.source

import androidx.lifecycle.LiveData
import com.expanse.app.newsreader.data.Result
import com.expanse.app.newsreader.data.entities.NewsEntity
import com.expanse.app.newsreader.model.NewsItem
import kotlinx.coroutines.flow.Flow

interface NewsReaderDataSource {

    fun observeNewsEntity(): LiveData<Result<List<NewsEntity>>>

    suspend fun saveNewsEntity(newsEntity: NewsEntity)

    suspend fun deleteNewsEntities()

    suspend fun getNewsFromAPI(apiKey: String): Flow<Result<List<NewsItem>>>
}
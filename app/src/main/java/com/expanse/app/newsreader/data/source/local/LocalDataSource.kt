package com.expanse.app.newsreader.data.source.local

import androidx.lifecycle.LiveData
import com.expanse.app.newsreader.data.Result
import com.expanse.app.newsreader.data.entities.NewsEntity
import com.expanse.app.newsreader.data.source.NewsReaderDataSource
import com.expanse.app.newsreader.model.NewsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSource internal constructor(
    private val newsReaderDAO: NewsReaderDAO) : NewsReaderDataSource {

    override fun observeNewsEntity(): LiveData<List<NewsEntity>> {
        return newsReaderDAO.observeNewsEntity()
    }

    override suspend fun saveNewsEntity(newsEntity: NewsEntity) {
        newsReaderDAO.insertNewsEntity(newsEntity)
    }

    override suspend fun deleteNewsEntities() {
        newsReaderDAO.deleteNewsEntities()
    }

    override suspend fun getNewsFromAPI(apiKey: String): Flow<Result<List<NewsItem>>> = flow {
        emit(Result.Error(Throwable("Local Doesn't implement this method")))
    }
}
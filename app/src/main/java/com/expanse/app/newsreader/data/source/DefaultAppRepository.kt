package com.expanse.app.newsreader.data.source

import androidx.lifecycle.LiveData
import com.expanse.app.newsreader.data.Result
import com.expanse.app.newsreader.data.entities.NewsEntity
import com.expanse.app.newsreader.model.NewsItem
import kotlinx.coroutines.flow.Flow

class DefaultAppRepository(
    private val remoteDataSource: NewsReaderDataSource,
    private val localDataSource: NewsReaderDataSource
) : NewsReaderRepository {

    override fun observeNewsEntity(): LiveData<Result<List<NewsEntity>>> =
        localDataSource.observeNewsEntity()

    override suspend fun saveNewsEntity(newsEntity: NewsEntity) =
        localDataSource.saveNewsEntity(newsEntity)

    override suspend fun deleteNewsEntities() = localDataSource.deleteNewsEntities()

    override suspend fun getNewsFromAPI(apiKey: String): Flow<Result<List<NewsItem>>> =
        remoteDataSource.getNewsFromAPI(apiKey)
}
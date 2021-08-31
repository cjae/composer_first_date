package com.expanse.app.newsreader.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.expanse.app.newsreader.data.Result
import com.expanse.app.newsreader.data.entities.NewsEntity
import com.expanse.app.newsreader.data.source.NewsReaderDataSource
import com.expanse.app.newsreader.model.NewsItem
import com.expanse.app.newsreader.utils.ServerUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource internal constructor(
    private val service: ServiceGenerator
): NewsReaderDataSource {

    override fun observeNewsEntity(): LiveData<Result<List<NewsEntity>>> = MutableLiveData()

    override suspend fun saveNewsEntity(newsEntity: NewsEntity) {/*EMPTY BLOCK*/}

    override suspend fun deleteNewsEntities()  {/*EMPTY BLOCK*/}

    override suspend fun getNewsFromAPI(apiKey: String): Flow<Result<List<NewsItem>>> = flow {
        emit(Result.Loading)
        try {
            val result = service.getNews(apiKey = apiKey)
            if (result.status == ServerUtils.OK_STATUS) emit(Result.Success(result.results))
            else emit(Result.Error(Throwable(result.message)))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
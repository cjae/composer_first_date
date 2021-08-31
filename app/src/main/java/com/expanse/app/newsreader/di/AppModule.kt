package com.expanse.app.newsreader.di

import com.expanse.app.newsreader.data.source.NewsReaderDataSource
import com.expanse.app.newsreader.data.source.local.LocalDataSource
import com.expanse.app.newsreader.data.source.local.NewsReaderDAO
import com.expanse.app.newsreader.data.source.remote.RemoteDataSource
import com.expanse.app.newsreader.data.source.remote.ServiceGenerator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(RUNTIME)
    annotation class AppRemoteDataSource

    @Qualifier
    @Retention(RUNTIME)
    annotation class AppLocalDataSource

    @Singleton
    @AppRemoteDataSource
    @Provides
    fun provideRemoteDataSource(service: ServiceGenerator): NewsReaderDataSource = RemoteDataSource(service)

    @Singleton
    @AppLocalDataSource
    @Provides
    fun provideLocalDataSource(newsReaderDAO: NewsReaderDAO): NewsReaderDataSource = LocalDataSource(newsReaderDAO)
}
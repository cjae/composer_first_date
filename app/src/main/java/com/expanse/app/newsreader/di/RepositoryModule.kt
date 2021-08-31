package com.expanse.app.newsreader.di

import com.expanse.app.newsreader.data.source.DefaultAppRepository
import com.expanse.app.newsreader.data.source.NewsReaderDataSource
import com.expanse.app.newsreader.data.source.NewsReaderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAppRepository(
        @AppModule.AppRemoteDataSource remoteDataSource: NewsReaderDataSource,
        @AppModule.AppLocalDataSource localDataSource: NewsReaderDataSource
    ): NewsReaderRepository = DefaultAppRepository(remoteDataSource, localDataSource)
}
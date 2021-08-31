package com.expanse.app.newsreader.di

import android.content.Context
import androidx.room.Room
import com.expanse.app.newsreader.data.source.local.NewsReaderDAO
import com.expanse.app.newsreader.data.source.local.NewsReaderDatabase
import com.expanse.app.newsreader.utils.ServerUtils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NewsReaderDatabase {
        return Room.databaseBuilder(context, NewsReaderDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAppDAO(roomDatabase: NewsReaderDatabase): NewsReaderDAO = roomDatabase.newsReaderDAO()
}
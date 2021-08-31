package com.expanse.app.newsreader.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.expanse.app.newsreader.data.entities.NewsEntity

@Database(
    version = 1,
    entities = [ NewsEntity::class ]
)
abstract class NewsReaderDatabase : RoomDatabase() { abstract fun newsReaderDAO(): NewsReaderDAO }
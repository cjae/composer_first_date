package com.expanse.app.newsreader.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.expanse.app.newsreader.data.entities.NewsEntity

@Dao
interface NewsReaderDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsEntity(newsEntity: NewsEntity)

    @Query("DELETE FROM news_table")
    suspend fun deleteNewsEntities()

    @Query("SELECT * FROM news_table")
    fun observeNewsEntity(): LiveData<List<NewsEntity>>
}
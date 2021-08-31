package com.expanse.app.newsreader.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.expanse.app.newsreader.data.entities.NewsEntity
import com.expanse.app.newsreader.data.Result

object CleanUpUtils {

    fun cleanUpNewsEntity(tasksResult: Result<List<NewsEntity>>): LiveData<List<NewsEntity>> {
        val result = MutableLiveData<List<NewsEntity>>()
        if (tasksResult is Result.Success) result.value = tasksResult.data!!
        else result.value = emptyList()
        return result
    }
}
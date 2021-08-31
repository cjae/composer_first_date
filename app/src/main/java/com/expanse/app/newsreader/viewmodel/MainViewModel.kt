package com.expanse.app.newsreader.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.expanse.app.newsreader.BuildConfig
import com.expanse.app.newsreader.data.Result
import com.expanse.app.newsreader.data.source.NewsReaderRepository
import com.expanse.app.newsreader.model.NewsItem
import com.expanse.app.newsreader.utils.DialogQueue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsReaderRepository
) : ViewModel() {

    val newsList: MutableState<List<NewsItem>> = mutableStateOf(ArrayList())
    val onLoad: MutableState<Boolean> = mutableStateOf(false)
    val loading = mutableStateOf(false)
    val dialogQueue = DialogQueue()

    fun getNewsData() {
        viewModelScope.launch {
            repository.getNewsFromAPI(BuildConfig.API_KEY)
                .onEach {
                    when(it) {
                        is Result.Success<List<NewsItem>> -> {
                            loading.value = false
                            it.data?.let { data -> newsList.value = data }
                        }
                        is Result.Error -> {
                            loading.value = false
                            dialogQueue.appendErrorMessage("An Error Occurred", it.exception.localizedMessage!!)
                        }
                        is Result.Loading -> loading.value = true
                    }
                }
                .launchIn(viewModelScope)
        }
    }
}
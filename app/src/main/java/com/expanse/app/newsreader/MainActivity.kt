package com.expanse.app.newsreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.expanse.app.newsreader.ui.components.NewsList
import com.expanse.app.newsreader.ui.theme.NewsReaderTheme
import com.expanse.app.newsreader.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainContent(
            viewModel,
            onNavigateToBrowser = { url ->
               Timber.d(url)
            }) }
    }
}

@Composable
fun MainContent(
    viewModel: MainViewModel,
    onNavigateToBrowser: (String) -> Unit) {

    val onLoad = viewModel.onLoad.value
    if (!onLoad) {
        viewModel.onLoad.value = true
        viewModel.getNewsData()
    }

    val data = viewModel.newsList.value

    val loading = viewModel.loading.value

    val dialogQueue = viewModel.dialogQueue

    NewsReaderTheme (dialogQueue = dialogQueue.queue.value) {
        Scaffold (
            topBar = { TopAppBar(title = { Text(text = "Newsfeed", color = MaterialTheme.colors.onSurface)}, backgroundColor = MaterialTheme.colors.surface)  },
            content = {
                Column {
                    if (loading) { LinearProgressIndicator(Modifier.fillMaxWidth()) }
                    NewsList(data = data, onNavigateToBrowser = onNavigateToBrowser)
                }
            }
        )
    }
}
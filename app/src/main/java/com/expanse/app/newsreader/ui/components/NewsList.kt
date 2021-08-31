package com.expanse.app.newsreader.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.expanse.app.newsreader.model.NewsItem

@Composable
fun NewsList(
    data: List<NewsItem>,
    onNavigateToBrowser: (String) -> Unit
){
    Box(modifier = Modifier.background(color = MaterialTheme.colors.surface)) {
        if(data.isEmpty()){
            EmptyView()
        } else {
            LazyColumn(contentPadding = PaddingValues(top = 2.dp, bottom = 2.dp)){
                itemsIndexed(items = data) { _, newsItem ->
                    NewsCard(
                        newsItem = newsItem,
                        onClick = { onNavigateToBrowser(newsItem.url) }
                    )
                }
            }
        }
    }
}








package com.expanse.app.newsreader.ui.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.expanse.app.newsreader.model.NewsItem
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun NewsCard(
    newsItem: NewsItem,
    onClick: () -> Unit,
) {
    Card(Modifier
        .fillMaxWidth()
        .padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp)
        .clickable(onClick = onClick)
    ) {
        Box(Modifier.fillMaxWidth()) {
            Image(
                painter = rememberCoilPainter(newsItem.urlToImage),
                contentDescription = newsItem.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )

            Surface(
                color = Color.Black,
                modifier = Modifier.alpha(0.7f)
            ) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp))
            }

            Column(modifier = Modifier.align(Alignment.BottomStart).padding(6.dp)) {
                Text(
                    text = newsItem.title ?: "",
                    maxLines = 2,
                    fontSize = 18.sp,
                    color = Color.White,
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = newsItem.author ?: "",
                    maxLines = 1,
                    color = Color.White,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}



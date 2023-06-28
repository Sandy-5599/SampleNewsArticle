package com.example.samplenewsarticle.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.samplenewsarticle.R
import com.example.samplenewsarticle.data.model.Asset
import java.text.DateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NewsArticleItem(asset: Asset, openArticleCallback: (String) -> Unit) {
    // this function used for defining and rendering each asset from NewsArticle's Asset list
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .testTag("asset")
            .clickable { openArticleCallback(asset.url ?: "") },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            val imageLoaded: MutableState<Boolean> = remember { mutableStateOf(false) }
            Box(modifier = Modifier) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)
                        .padding(end = 4.dp),
                    contentScale = ContentScale.Fit,

                    painter = rememberAsyncImagePainter(
                        model = asset.getSmallestImageUrl(),
                        onSuccess = {
                            imageLoaded.value = true
                        }),
                    contentDescription = stringResource(id = R.string.news_articles_image),
                )
                if (!imageLoaded.value) {
                    LoadingView()
                }
            }
            Column {
                if (asset.timeStamp != null) {
                    val formattedDate = remember(asset.timeStamp) {
                        val dateFormat =
                            DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault())
                        dateFormat.format(Date(asset.timeStamp))
                    }
                    Text(
                        text = formattedDate,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .align(Alignment.End)
                    )
                }
                Text(
                    text = asset.headline ?: "",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = asset.theAbstract ?: "",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = asset.byLine ?: "",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}
package com.example.samplenewsarticle.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.samplenewsarticle.R
import com.example.samplenewsarticle.data.model.NewsArticles
import com.example.samplenewsarticle.presentation.viewmodel.NewsArticleViewModel
import com.example.samplenewsarticle.repository.sampleMock
import timber.log.Timber

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsArticleListScreen(
    newsArticles: NewsArticles?,
    isLoadingArticlesState: MutableState<ApiCallState>,
    openArticleCallback: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.news_articles)) }
            )
        }
    ) {
        Timber.tag("NewsArticleListScreen started loading")

        Column(modifier = Modifier.padding(16.dp)) {
            when (isLoadingArticlesState.value) {
                ApiCallState.LOADING -> {
                    Column(modifier = Modifier.testTag("loadingView")) {
                        LoadingView()
                    }

                }
                ApiCallState.SUCCESS -> {
                    if (newsArticles?.assets?.isNotEmpty() == true) {

                        val sortedList = newsArticles.getSortedListOfAssets() // It will get the sorted assets list based on latest timestamp

                        LazyColumn(modifier = Modifier.testTag("newsArticlesList")){
                            itemsIndexed(sortedList) { index, asset ->
                                // Wrap the NewsArticleItem with Box and assign a test tag
                                Box(modifier = Modifier.testTag("NewsArticleItem$index")) {
                                    NewsArticleItem(
                                        asset = asset,
                                        openArticleCallback = openArticleCallback
                                    )
                                }
                            }
                        }
                    } else {
                        Column(modifier = Modifier.testTag("emptyList").padding(16.dp)) {
                            //handle error scenario for empty list
                        }
                    }
                }
                ApiCallState.ERROR -> {
                    Column(modifier = Modifier.testTag("errorScreen").padding(16.dp)) {
                        //handle error scenario or show error page here
                    }
                }
            }

        }
    }
}
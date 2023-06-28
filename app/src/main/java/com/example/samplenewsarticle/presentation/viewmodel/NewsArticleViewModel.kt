package com.example.samplenewsarticle.presentation.viewmodel

import android.content.ContentValues.TAG
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplenewsarticle.apiresponse.ApiFailure
import com.example.samplenewsarticle.apiresponse.ApiSuccess
import com.example.samplenewsarticle.data.model.NewsArticles
import com.example.samplenewsarticle.repository.NewsArticleRepository
import com.example.samplenewsarticle.ui.screens.ApiCallState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewsArticleViewModel @Inject constructor(
    private val newsRepository: NewsArticleRepository
) : ViewModel() {
    val newsArticles: MutableState<NewsArticles?> = mutableStateOf(null)
    val isLoadingArticlesState: MutableState<ApiCallState> = mutableStateOf(ApiCallState.LOADING)

    fun loadNewsArticles() {
        Timber.d("loadNewsArticles  in view model")
        isLoadingArticlesState.value =
            ApiCallState.LOADING //this state used for showing progress indicator
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            Timber.tag(TAG).e(
                throwable,
                "loadNewsArticles in viewModel received exception: ${throwable.localizedMessage}"
            )
            isLoadingArticlesState.value = ApiCallState.ERROR
        }
        ) {
            newsRepository.getNewsArticles().collect { apiResult ->
                when (apiResult) {
                    is ApiSuccess -> {
                        newsArticles.value =
                            apiResult.value //assign api result list to newsArticles
                        isLoadingArticlesState.value =
                            ApiCallState.SUCCESS //it will stop progress indicator
                    }

                    is ApiFailure -> {
                        isLoadingArticlesState.value = ApiCallState.ERROR
                        Timber.tag(TAG).e(
                            "loadNewsArticles received ApiException in ViewModel"
                        )
                    }
                }
            }
        }
    }
}
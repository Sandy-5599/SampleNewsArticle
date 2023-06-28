package com.example.samplenewsarticle

import android.app.Application
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.samplenewsarticle.presentation.viewmodel.NewsArticleViewModel
import com.example.samplenewsarticle.ui.navigation.NewsApp
import com.example.samplenewsarticle.ui.theme.NewsArticlesTheme
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

}
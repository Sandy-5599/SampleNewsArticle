package com.example.samplenewsarticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.samplenewsarticle.presentation.viewmodel.NewsArticleViewModel
import com.example.samplenewsarticle.ui.navigation.NewsApp
import com.example.samplenewsarticle.ui.theme.NewsArticlesTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private val newsViewModel: NewsArticleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Timber for logging
            Timber.plant(Timber.DebugTree())
        setContent {
            NewsArticlesTheme {
                NewsApp(newsViewModel)
            }
        }
    }
}
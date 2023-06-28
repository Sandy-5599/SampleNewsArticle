package com.example.samplenewsarticle.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplenewsarticle.presentation.viewmodel.NewsArticleViewModel
import com.example.samplenewsarticle.ui.screens.NewsArticleListScreen
import com.example.samplenewsarticle.ui.screens.WelcomeScreen
import com.example.samplenewsarticle.ui.webview.WebViewActivity


@Composable
fun NewsApp(newsViewModel: NewsArticleViewModel) {
    // Define your app's navigation logic and screens here
    val navController = rememberNavController()

    val startDestination = "welcome.route"

    NavHost(navController, startDestination = startDestination) {
        addWelcomePage(navController, newsViewModel)
        addNewsArticlesPage(newsViewModel)

    }
}

private fun NavGraphBuilder.addWelcomePage(
    navController: NavHostController,
    newsViewModel: NewsArticleViewModel
) {
    composable("welcome.route") {
        val context = LocalContext.current
        WelcomeScreen {
            newsViewModel.loadNewsArticles()
            navController.navigate("newsArticles.route")
        }
    }
}

private fun NavGraphBuilder.addNewsArticlesPage(
    newsViewModel: NewsArticleViewModel
) {
    composable("newsArticles.route") {
        val context = LocalContext.current
        NewsArticleListScreen(
            newsArticles = newsViewModel.newsArticles.value,
            isLoadingArticlesState = newsViewModel.isLoadingArticlesState,
        ) { url ->
            openWebView(url, context)
        }
    }
}

private fun openWebView(url: String, context: Context) {
    WebViewActivity.startActivity(context, url)
}
package com.example.samplenewsarticle.ui.screens

import android.content.res.Resources
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.samplenewsarticle.data.model.Asset
import com.example.samplenewsarticle.data.model.NewsArticles
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsArticleUITest {

    private lateinit var resources: Resources
    private lateinit var packageName: String

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        packageName = context.packageName
        resources = context.resources
    }

    @Test
    fun testNewsArticleListScreenLoading() {
        // Verify that the LoadingView is displayed when the articles are being loaded
        composeTestRule.setContent {
            NewsArticleListScreen(
                newsArticles = NewsArticles.newsArticlesMock,
                isLoadingArticlesState = mutableStateOf(ApiCallState.LOADING),
                openArticleCallback = {}
            )
        }

        composeTestRule
            .onNodeWithTag("loadingView")
            .assertIsDisplayed()
    }

    @Test
    fun testNewsArticleListSuccessScreen() {
        // Verify that the LoadingView is displayed when the articles are being loaded

        composeTestRule.setContent {
            NewsArticleListScreen(
                newsArticles = NewsArticles.newsArticlesMock,
                isLoadingArticlesState = remember { mutableStateOf(ApiCallState.SUCCESS) },
                openArticleCallback = {}
            )
        }

        // Verify that the NewsArticlesList is displayed
        composeTestRule
            .onNodeWithTag("newsArticlesList")
            .assertIsDisplayed()

        // Verify that the correct number of NewsArticleItems are displayed and each NewsArticleItem is displayed
        val itemCount = NewsArticles.newsArticlesMock?.assets?.size
        for (index in 0 until itemCount!!) {
            composeTestRule
                .onNodeWithTag("NewsArticleItem$index")
                .assertIsDisplayed()
        }
    }

    @Test
    fun testNewsArticleListScreenWithNoAssets() {
        // Verify that the LoadingView is displayed when the articles are being loaded

        composeTestRule.setContent {
            NewsArticleListScreen(
                newsArticles = NewsArticles.newsArticlesNoAssetsMock,
                isLoadingArticlesState = remember { mutableStateOf(ApiCallState.SUCCESS) },
                openArticleCallback = {}
            )
        }
        composeTestRule
            .onNodeWithTag("emptyList")
            .assertIsDisplayed()
    }

    @Test
    fun testNewsArticleListErrorScreen() {
        // Verify that the LoadingView is displayed when the articles are being loaded

        composeTestRule.setContent {
            NewsArticleListScreen(
                newsArticles = null,
                isLoadingArticlesState = remember { mutableStateOf(ApiCallState.ERROR) },
                openArticleCallback = {}
            )
        }

        // Verify that the error message is displayed when there is an error loading the articles
        composeTestRule
            .onNodeWithTag("errorScreen")
            .assertIsDisplayed()
    }

    @Test
    fun testNewsArticleItemClick() {
        val mockArticleUrl = "https://www.example.com/article/1"

        composeTestRule.setContent {
            NewsArticleItem(
                asset = Asset.assetMock,
                openArticleCallback = {}
            )
        }
        // Verify that the byLine is displayed
        composeTestRule
            .onNodeWithText(Asset.assetMock.byLine ?: "")
            .assertIsDisplayed()
        // Verify that the theAbstract is displayed
        composeTestRule
            .onNodeWithText(Asset.assetMock.theAbstract ?: "")
            .assertIsDisplayed()
        // Verify that the headline is displayed
        composeTestRule
            .onNodeWithText(Asset.assetMock.headline ?: "")
            .assertIsDisplayed()
    }

}

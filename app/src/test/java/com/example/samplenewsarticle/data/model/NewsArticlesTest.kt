package com.example.samplenewsarticle.data.model

import junit.framework.TestCase

internal class NewsArticlesTest : TestCase() {

    private val expectedSortedAssetsList = listOf(
        Asset(
            url = "2",
            headline = null,
            byLine = "",
            theAbstract = "",
            relatedImages = listOf(
                RelatedImages(width = 20, url = "20"),
                RelatedImages(width = 5, url = "5"),
                RelatedImages(width = 10, url = "10")
            ),
            timeStamp = 1685481360000
        ),
        Asset(
            url = "1",
            headline = null,
            byLine = "",
            theAbstract = "",
            relatedImages = listOf(
                RelatedImages(width = 20, url = "20"),
                RelatedImages(width = 5, url = "5"),
                RelatedImages(width = 10, url = "10")
            ),
            timeStamp = 1553561488738
        ),
        Asset(
            url = "3",
            headline = null,
            byLine = "",
            theAbstract = "",
            relatedImages = listOf(
                RelatedImages(width = 20, url = "20"),
                RelatedImages(width = 5, url = "5"),
                RelatedImages(width = 10, url = "10")
            ),
            timeStamp = 1426357827234
        )
    )
    fun testGetSortedListOfAssets() {
        assertEquals(
            expectedSortedAssetsList,
            NewsArticles.newsArticlesDummyMock.getSortedListOfAssets()
        )
    }
}

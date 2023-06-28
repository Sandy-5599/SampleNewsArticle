package com.example.samplenewsarticle.data.model

import junit.framework.TestCase


class AssetTest : TestCase() {

    fun testGetSmallestImageUrl() {
        val asset1 = NewsArticles.newsArticlesMock?.assets?.get(0)
        val asset2 = NewsArticles.newsArticlesMock?.assets?.get(1)
        val asset3 = Asset.assetMock
        if (asset1 != null) {
            assertEquals(
                "https://www.fairfaxstatic.com.au/content/dam/images/h/1/7/4/l/g/image.related.articleLeadwide.1500x844.p5dcuc.13zzqx.png/1685577464607.jpg",
                asset1.getSmallestImageUrl()
            )
        }
        if (asset2 != null) {
            assertEquals(
                "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.thumbnail.375x250.p5dce5.13zzqx.png/1685577464607.jpg",
                asset2.getSmallestImageUrl()
            )
        }

        assertEquals(
            "5", asset3.getSmallestImageUrl()
        )
    }
}
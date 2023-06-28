package com.example.samplenewsarticle.data.model

import androidx.annotation.Keep

@Keep
data class Asset(
    val url: String? = "",
    val headline: String? = "",
    val theAbstract: String? = "",
    val byLine: String? = "",
    val relatedImages: List<RelatedImages>?,
    val timeStamp: Long?
) {
    fun getSmallestImageUrl(): String {
        return relatedImages
            ?.filter { it.width != null }
            ?.minByOrNull { it.width!! }
            ?.url ?: ""
    }

    companion object {

        val assetMock = Asset(
            url = "https://www.example.com/article/1",
            headline = null,
            byLine = "",
            theAbstract = "",
            relatedImages = listOf(
                RelatedImages(width = 20, url = "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.landscape.1174x783.p5dce5.13zzqx.png/1685577464607.jpg"),
                RelatedImages(width = 5, url = "5"),
                RelatedImages(width = 10, url = "10")
            ),
            timeStamp = 1553561488738
        )
    }
}
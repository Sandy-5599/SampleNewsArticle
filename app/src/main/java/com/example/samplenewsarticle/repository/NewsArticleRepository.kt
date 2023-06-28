package com.example.samplenewsarticle.repository

import androidx.annotation.Keep
import com.example.samplenewsarticle.apiresponse.ApiFailResponse
import com.example.samplenewsarticle.apiresponse.ApiResult
import com.example.samplenewsarticle.apiresponse.ApiSuccess
import com.example.samplenewsarticle.apiresponse.toApiResult
import com.example.samplenewsarticle.data.model.Asset
import com.example.samplenewsarticle.data.model.NewsArticles
import com.example.samplenewsarticle.services.NewsArticleService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

interface NewsArticleRepository {
    suspend fun getNewsArticles(): Flow<ApiResult<NewsArticles?, ApiFailResponse>>
    suspend fun getNewsArticlesFromMock(): Flow<ApiResult<NewsArticles?, ApiFailResponse>>
}

class NewsArticleRepositoryImpl @Inject constructor(
    private val apiService: NewsArticleService
) : NewsArticleRepository {

    override suspend fun getNewsArticles(): Flow<ApiResult<NewsArticles?, ApiFailResponse>> {

        Timber.d("getNewsArticles from Repository calling")
        val flows = flow {
            emit(
                apiService.getNewsArticles().toApiResult()
            )
        }.flowOn(Dispatchers.IO)
        return flows
    }

    //this function is not used at the moment its used for testing below Mock data instead API
    override suspend fun getNewsArticlesFromMock(): Flow<ApiResult<NewsArticles?, ApiFailResponse>> {

       val flows = flow {
            emit(
                ApiSuccess(
                    Gson().fromJson(
                        sampleMock,
                        MockArticles::class.java
                    ).mockArticlesList
                )
            )
        }.flowOn(Dispatchers.IO)
        return flows
    }
}

@Keep
data class MockArticles(
    val mockArticlesList: NewsArticles
)

val sampleMock =
    """
			{
			  "mockArticlesList": 
			    {
	"id": 67184313,
	"categories": [],
	"authors": [],
	"url": "/content/dam/lists/1/3/z/z/q/x/list.html",
	"lastModified": 1685577464607,
	"onTime": 1425955024417,
	"sponsored": false,
	"displayName": "AFR iPad Editor's Choice",
	"assets": [{
		"id": 1520675543,
		"categories": [{
			"name": "Residential",
			"sectionPath": "/real-estate/residential",
			"orderNum": 0
		}],
		"authors": [{
			"name": "Samantha Hutchinson",
			"title": "Reporter",
			"email": "samantha.hutchinson@smh.com.au",
			"relatedAssets": [],
			"relatedImages": []
		}],
		"url": "http://www.afr.com/real-estate/residential/count-on-two-years-to-get-a-bondi-apartment-approved-20230531-p5dcrb",
		"lastModified": 1685526714038,
		"sponsored": false,
		"headline": "Count on two years to get a Bondi apartment approved",
		"indexHeadline": "Count on two years to get a Bondi apartment approved",
		"tabletHeadline": "",
		"theAbstract": "Sydney builder Alistair Jones says the approval process is taking time and money and reducing the viability of medium density projects that would deliver much-needed housing supply.",
		"byLine": "Samantha Hutchinson",
		"acceptComments": false,
		"numberOfComments": 0,
		"relatedAssets": [],
		"relatedImages": [{
			"id": 1031856532,
			"categories": [],
			"brands": [],
			"authors": [],
			"url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/c/9/l/g/image.related.afrArticleLead.1536x1010.p5dcrb.13zzqx.png/1685602003603.jpg",
			"lastModified": 1685602003603,
			"sponsored": false,
			"description": "Builder Alistair Jones has waited 18 months to get approval to convert this freestanding home into a duplex. ",
			"photographer": "Dominic Lorrimer",
			"type": "afrArticleLead",
			"width": 1536,
			"height": 1010,
			"assetType": "IMAGE",
			"xLarge@2x": "",
			"large@2x": "",
			"timeStamp": 1685602003603
		}, {
			"id": 1031856532,
			"categories": [],
			"brands": [],
			"authors": [],
			"url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/c/9/l/g/image.related.articleLeadwide.1500x844.p5dcrb.13zzqx.png/1685602003603.jpg",
			"lastModified": 1685602003603,
			"sponsored": false,
			"description": "Builder Alistair Jones has waited 18 months to get approval to convert this freestanding home into a duplex. ",
			"photographer": "Dominic Lorrimer",
			"type": "articleLeadWide",
			"width": 1500,
			"height": 844,
			"assetType": "IMAGE",
			"xLarge@2x": "",
			"xLarge": "",
			"large@2x": "",
			"large": "",
			"thumbnail@2x": "",
			"thumbnail": "",
			"timeStamp": 1685602003603
		}, {
			"id": 1031857207,
			"categories": [],
			"brands": [],
			"authors": [],
			"url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/c/a/4/7/image.related.wideLandscape.1500x844.p5dcrb.13zzqx.png/1685577464607.jpg",
			"lastModified": 1685526713807,
			"sponsored": false,
			"description": " ",
			"photographer": "  ",
			"type": "wideLandscape",
			"width": 1500,
			"height": 844,
			"assetType": "IMAGE",
			"xLarge@2x": "",
			"xLarge": "",
			"large@2x": "",
			"large": "",
			"thumbnail@2x": "",
			"thumbnail": "",
			"timeStamp": 1685526712516
		} , {
			"id": 1031828645,
			"categories": [],
			"brands": [],
			"authors": [],
			"url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.landscape.1174x783.p5dce5.13zzqx.png/1685577464607.jpg",
			"lastModified": 1683252266624,
			"sponsored": false,
			"description": "Blockage: The pipeline of new housing shrank further in April.",
			"photographer": "Tamara Voninski",
			"type": "landscape",
			"width": 1174,
			"height": 783,
			"assetType": "IMAGE",
			"large@2x": "",
			"large": "",
			"thumbnail@2x": "",
			"thumbnail": "",
			"timeStamp": 1683252266624
		}],
		"companies": [],
		"legalStatus": "None",
		"sources": [{
			"tagId": "AFR"
		}],
		"assetType": "ARTICLE",
		"overrides": {
			"overrideHeadline": "Housing pipeline shrinks as apartment approvals plummet",
			"overrideAbstract": "Economic headwinds are hitting Australia’s largest cities, as they try to boost housing development to overcome a long-standing shortage of homes."
		},
		"timeStamp": 1685429492000
	}],
	"relatedAssets": [],
	"relatedImages": [],
	"assetType": "ASSET_LIST",
	"timeStamp": 1685577463560
} 


			}
		""".trimIndent()
val assetMock1: Asset = Gson()
    .fromJson(sampleMock, Asset::class.java)
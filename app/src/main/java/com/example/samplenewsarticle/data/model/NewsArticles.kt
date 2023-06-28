package com.example.samplenewsarticle.data.model

import androidx.annotation.Keep
import com.google.gson.Gson

@Keep
data class NewsArticles(
    val assets: List<Asset>?
) {
    // This function returns the sorted assets list based on latest timestamp
    fun getSortedListOfAssets(): List<Asset> {
        return assets?.sortedByDescending { it.timeStamp } ?: emptyList()
    }

    companion object {

        val newsArticlesDummyMock = NewsArticles(
            assets = listOf(
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
        )

        val newsArticlesNoAssetsMock = NewsArticles(
            assets = emptyList()
        )

        val newsArticlesMock: NewsArticles? = Gson()
            .fromJson(
                """
            {

                      "id": 67184313,
                      "categories": [],
                      "authors": [],
                      "url": "/content/dam/lists/1/3/z/z/q/x/list.html",
                      "lastModified": 1685577464607,
                      "onTime": 1425955024417,
                      "sponsored": false,
                      "displayName": "AFR iPad Editor's Choice",
                      "assets": [
                        {
                          "id": 1520675652,
                          "categories": [
                            {
                              "name": "Chanticleer",
                              "sectionPath": "/brand/chanticleer",
                              "orderNum": 0
                            }
                          ],
                          "authors": [
                            {
                              "name": "Chanticleer",
                              "title": "Columnist",
                              "email": "",
                              "relatedImages": [
                                {
                                  "id": 67385547,
                                  "categories": [],
                                  "brands": [],
                                  "authors": [],
                                  "url": "https://www.fairfaxstatic.com.au/content/dam/images/1/4/4/b/0/r/image.imgtype.afrWoodcutAuthorImage.140x140.png/1426357827234.png",
                                  "lastModified": 1426357827234,
                                  "sponsored": false,
                                  "description": " ",
                                  "photographer": "",
                                  "type": "afrWoodcutAuthorImage",
                                  "width": 140,
                                  "height": 140,
                                  "assetType": "IMAGE",
                                  "timeStamp": 1426357827234
                                }
                              ]
                            }
                          ],
                          "url": "http://www.afr.com/brand/chanticleer/rba-is-between-a-housing-rock-and-a-hard-place-20230531-p5dcuc",
                          "lastModified": 1685512339534,
                          "sponsored": false,
                          "headline": "RBA is between a housing rock and a hard place",
                          "indexHeadline": "RBA is between a housing rock and a hard place",
                          "tabletHeadline": "",
                          "theAbstract": "It is instructive that one of the hottest topics at Philip Lowe’s Senate appearance was housing, because it’s making his fight against inflation that much harder. ",
                          "byLine": "James Thomson",
                          "acceptComments": false,
                          "numberOfComments": 0,
                          "relatedAssets": [
                            {
                              "id": 1520675394,
                              "categories": [
                                {
                                  "name": "Equity Markets",
                                  "sectionPath": "/markets/equity-markets",
                                  "orderNum": 0
                                }
                              ],
                              "authors": [
                                {
                                  "name": "Timothy Moore",
                                  "title": "Online editor ",
                                  "email": "timothy.moore@afr.com",
                                  "relatedAssets": [],
                                  "relatedImages": []
                                }
                              ],
                              "url": "http://www.afr.com/markets/equity-markets/asx-to-slide-at-the-open-oil-drops-20230530-p5dcn6",
                              "lastModified": 1685515278354,
                              "sponsored": false,
                              "headline": "ASX hits two-month low as traders up bet for RBA rate rise",
                              "indexHeadline": "ASX hits two-month low as traders up bet for RBA rate rise",
                              "theAbstract": "Shares extend losses on hot inflation data. Coal prices, miners sink; Oil below BoQ drops after being slapped with APRA undertaking. Follow updates here.",
                              "body": "",
                              "byLine": "Timothy Moore, Tom Richardson, Alex Gluyas, Sarah Jones and Joanne Tran",
                              "acceptComments": false,
                              "numberOfComments": 0,
                              "relatedAssets": [],
                              "relatedImages": [],
                              "companies": [],
                              "legalStatus": "None",
                              "sources": [
                                {
                                  "tagId": "AFR"
                                }
                              ],
                              "liveArticleSummary": "",
                              "relatedPosts": [],
                              "live": true,
                              "assetType": "LIVE_ARTICLE",
                              "extendedAbstract": "",
                              "timeStamp": 1685481360000
                            },
                            {
                              "id": 1520675069,
                              "categories": [
                                {
                                  "name": "Residential",
                                  "sectionPath": "/real-estate/residential",
                                  "orderNum": 0
                                }
                              ],
                              "authors": [
                                {
                                  "name": "Michael Bleby",
                                  "title": "Senior Reporter",
                                  "email": "mbleby@afr.com.au",
                                  "relatedAssets": [],
                                  "relatedImages": [
                                    {
                                      "id": 1030202028,
                                      "categories": [],
                                      "brands": [],
                                      "authors": [],
                                      "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/1/c/s/z/0/image.imgtype.afrWoodcutAuthorImage.140x140.png/1553561488738.png",
                                      "lastModified": 1553561488738,
                                      "sponsored": false,
                                      "description": "",
                                      "photographer": "",
                                      "type": "afrWoodcutAuthorImage",
                                      "width": 140,
                                      "height": 140,
                                      "assetType": "IMAGE",
                                      "timeStamp": 1553561488738
                                    }
                                  ]
                                }
                              ],
                              "url": "http://www.afr.com/real-estate/residential/housing-pipeline-shrinks-as-apartment-approvals-plummet-20230530-p5dce5",
                              "lastModified": 1685437211386,
                              "sponsored": false,
                              "assetType": "ARTICLE",
                              "headline": "Housing pipeline shrinks as apartment approvals plummet",
                              "timeStamp": 1685429492000
                            }
                          ],
                          "relatedImages": [
                            {
                              "id": 1029937156,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/1/7/4/l/g/image.related.wideLandscape.1500x844.p5dcuc.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1540512537539,
                              "sponsored": false,
                              "description": "The RBA is facing pressure from two quarters on housing. ",
                              "photographer": "Rob Homer",
                              "type": "wideLandscape",
                              "width": 300,
                              "height": 244,
                              "assetType": "IMAGE",
                              "xLarge@2x": "",
                              "xLarge": "",
                              "large@2x": "",
                              "large": "",
                              "thumbnail@2x": "",
                              "thumbnail": "",
                              "timeStamp": 1540512537000
                            },
                            {
                              "id": 1029937156,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/1/7/4/l/g/image.related.articleLeadwide.1500x844.p5dcuc.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1540512537539,
                              "sponsored": false,
                              "description": "The RBA is facing pressure from two quarters on housing. ",
                              "photographer": "Rob Homer",
                              "type": "articleLeadWide",
                              "width": 200,
                              "height": 244,
                              "assetType": "IMAGE",
                              "xLarge@2x": "",
                              "xLarge": "",
                              "large@2x": "",
                              "large": "",
                              "thumbnail@2x": "",
                              "thumbnail": "",
                              "timeStamp": 1540512537000
                            }
                          ],
                          "signPost": "OPINION",
                          "companies": [],
                          "legalStatus": "None",
                          "sources": [
                            {
                              "tagId": "AFR"
                            }
                          ],
                          "assetType": "ARTICLE",
                          "overrides": {
                            "overrideHeadline": "RBA is between a housing rock and a hard place",
                            "overrideAbstract": "It is instructive that one of the hottest topics at Philip Lowe’s Senate appearance was housing, because it’s making his fight against inflation that much harder. "
                          },
                          "timeStamp": 1685509311000
                        },
                        {
                          "id": 1520675069,
                          "categories": [
                            {
                              "name": "Residential",
                              "sectionPath": "/real-estate/residential",
                              "orderNum": 0
                            }
                          ],
                          "authors": [
                            {
                              "name": "Michael Bleby",
                              "title": "Senior Reporter",
                              "email": "mbleby@afr.com.au",
                              "relatedAssets": [],
                              "relatedImages": [
                                {
                                  "id": 1030202028,
                                  "categories": [],
                                  "brands": [],
                                  "authors": [],
                                  "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/1/c/s/z/0/image.imgtype.afrWoodcutAuthorImage.140x140.png/1553561488738.png",
                                  "lastModified": 1553561488738,
                                  "sponsored": false,
                                  "description": "",
                                  "photographer": "",
                                  "type": "afrWoodcutAuthorImage",
                                  "width": 140,
                                  "height": 140,
                                  "assetType": "IMAGE",
                                  "timeStamp": 1553561488738
                                }
                              ]
                            }
                          ],
                          "url": "http://www.afr.com/real-estate/residential/housing-pipeline-shrinks-as-apartment-approvals-plummet-20230530-p5dce5",
                          "lastModified": 1685437211386,
                          "sponsored": false,
                          "headline": "Housing pipeline shrinks as apartment approvals plummet",
                          "indexHeadline": "Housing pipeline shrinks as apartment approvals plummet",
                          "tabletHeadline": "",
                          "theAbstract": "Economic headwinds are hitting Australia’s largest cities, as they try to boost housing development to overcome a long-standing shortage of homes.",
                          "byLine": "Michael Bleby",
                          "acceptComments": false,
                          "numberOfComments": 0,
                          "relatedAssets": [
                            {
                              "id": 1520674664,
                              "categories": [
                                {
                                  "name": "Residential",
                                  "sectionPath": "/real-estate/residential",
                                  "orderNum": 0
                                }
                              ],
                              "authors": [
                                {
                                  "name": "John Kehoe",
                                  "title": "Senior Writer",
                                  "email": "jkehoe@afr.com ",
                                  "relatedAssets": [],
                                  "relatedImages": [
                                    {
                                      "id": 1030192041,
                                      "categories": [],
                                      "brands": [],
                                      "authors": [],
                                      "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/1/c/l/9/l/image.imgtype.afrWoodcutAuthorImage.140x140.png/1553046200666.png",
                                      "lastModified": 1553046200666,
                                      "sponsored": false,
                                      "description": "",
                                      "photographer": "",
                                      "type": "afrWoodcutAuthorImage",
                                      "width": 140,
                                      "height": 140,
                                      "assetType": "IMAGE",
                                      "timeStamp": 1553046200666
                                    }
                                  ]
                                }
                              ],
                              "url": "http://www.afr.com/real-estate/residential/missing-middle-homes-would-benefit-boomers-and-millennials-20230529-p5dc2w",
                              "lastModified": 1685351367933,
                              "sponsored": false,
                              "assetType": "ARTICLE",
                              "headline": "‘Missing middle’ homes would benefit Boomers, Millennials",
                              "timeStamp": 1685344903000
                            },
                            {
                              "id": 1520654055,
                              "categories": [
                                {
                                  "name": "Residential",
                                  "sectionPath": "/real-estate/residential",
                                  "orderNum": 0
                                }
                              ],
                              "authors": [
                                {
                                  "name": "Larry Schlesinger",
                                  "title": "Reporter",
                                  "email": "larry.schlesinger@afr.com.au",
                                  "relatedAssets": [],
                                  "relatedImages": [
                                    {
                                      "id": 1030200199,
                                      "categories": [],
                                      "brands": [],
                                      "authors": [],
                                      "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/1/c/r/k/7/image.imgtype.afrWoodcutAuthorImage.140x140.png/1553476792466.png",
                                      "lastModified": 1553476792466,
                                      "sponsored": false,
                                      "description": "",
                                      "photographer": "",
                                      "type": "afrWoodcutAuthorImage",
                                      "width": 140,
                                      "height": 140,
                                      "assetType": "IMAGE",
                                      "timeStamp": 1553476792466
                                    }
                                  ]
                                }
                              ],
                              "url": "http://www.afr.com/real-estate/residential/housing-industry-crunch-triggers-a-surge-in-development-sites-20230328-p5cw6f",
                              "lastModified": 1680074352831,
                              "sponsored": false,
                              "assetType": "ARTICLE",
                              "headline": "Housing crunch triggers surge in development site listings",
                              "timeStamp": 1680074251000
                            }
                          ],
                          "relatedImages": [
                            {
                              "id": 1031828645,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.wideLandscape.1500x844.p5dce5.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1683252266624,
                              "sponsored": false,
                              "description": "Blockage: The pipeline of new housing shrank further in April.",
                              "photographer": "Tamara Voninski",
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
                              "timeStamp": 1683252266624
                            },
                            {
                              "id": 1031828645,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.thumbnail.375x250.p5dce5.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1683252266624,
                              "sponsored": false,
                              "description": "Blockage: The pipeline of new housing shrank further in April.",
                              "photographer": "Tamara Voninski",
                              "type": "thumbnail",
                              "width": 375,
                              "height": 250,
                              "assetType": "IMAGE",
                              "timeStamp": 1683252266624
                            },
                            {
                              "id": 1031828645,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.afrArticleLead.1536x1010.p5dce5.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1683252266624,
                              "sponsored": false,
                              "description": "Blockage: The pipeline of new housing shrank further in April.",
                              "photographer": "Tamara Voninski",
                              "type": "afrArticleLead",
                              "width": 1536,
                              "height": 1010,
                              "assetType": "IMAGE",
                              "xLarge@2x": "",
                              "large@2x": "",
                              "timeStamp": 1683252266624
                            },
                            {
                              "id": 1031828645,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.articleLeadwide.1500x844.p5dce5.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1683252266624,
                              "sponsored": false,
                              "description": "Blockage: The pipeline of new housing shrank further in April.",
                              "photographer": "Tamara Voninski",
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
                              "timeStamp": 1683252266624
                            },
                            {
                              "id": 1031828645,
                              "categories": [],
                              "brands": [],
                              "authors": [],
                              "url": "https://www.fairfaxstatic.com.au/content/dam/images/h/2/b/o/2/t/image.related.afrIndexLead.1536x1010.p5dce5.13zzqx.png/1685577464607.jpg",
                              "lastModified": 1683252266624,
                              "sponsored": false,
                              "description": "Blockage: The pipeline of new housing shrank further in April.",
                              "photographer": "Tamara Voninski",
                              "type": "afrIndexLead",
                              "width": 1536,
                              "height": 1010,
                              "assetType": "IMAGE",
                              "xLarge@2x": "",
                              "xLarge": "",
                              "large@2x": "",
                              "large": "",
                              "thumbnail@2x": "",
                              "thumbnail": "",
                              "timeStamp": 1683252266624
                            },
                            {
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
                            }
                          ],
                          "companies": [],
                          "legalStatus": "None",
                          "sources": [
                            {
                              "tagId": "AFR"
                            }
                          ],
                          "assetType": "ARTICLE",
                          "overrides": {
                            "overrideHeadline": "Housing pipeline shrinks as apartment approvals plummet",
                            "overrideAbstract": "Economic headwinds are hitting Australia’s largest cities, as they try to boost housing development to overcome a long-standing shortage of homes."
                          },
                          "timeStamp": 1685429492000
                        }
                      ],
                      "relatedAssets": [],
                      "relatedImages": [],
                      "assetType": "ASSET_LIST",
                      "timeStamp": 1685577463560
                    
                    } """.trimIndent(), NewsArticles::class.java
            )

    }

}


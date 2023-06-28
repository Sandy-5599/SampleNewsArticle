package com.example.samplenewsarticle.services


import com.example.samplenewsarticle.data.model.NewsArticles
import retrofit2.Response
import retrofit2.http.GET

interface NewsArticleService {
    @GET("1/coding_test/13ZZQX/full")
    suspend fun getNewsArticles(): Response<NewsArticles>
}

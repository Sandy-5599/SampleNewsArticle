package com.example.samplenewsarticle.di

import com.example.samplenewsarticle.repository.NewsArticleRepository
import com.example.samplenewsarticle.repository.NewsArticleRepositoryImpl
import com.example.samplenewsarticle.services.NewsArticleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
object NewsModule {
    @Provides
    fun provideApiService(): NewsArticleService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bruce-v2-mob.fairfaxmedia.com.au/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NewsArticleService::class.java)
    }

    @Provides
    fun provideArticleRepository(apiService: NewsArticleService): NewsArticleRepository {
        return NewsArticleRepositoryImpl(apiService)
    }
}
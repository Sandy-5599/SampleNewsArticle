package com.example.samplenewsarticle.apiresponse

import android.content.Context
import androidx.annotation.Keep
import com.example.samplenewsarticle.R
import okhttp3.Response
import okhttp3.ResponseBody

@Keep
data class ApiFailResponse(
	val response: Response?,
	val errorBody: ResponseBody?
)
package com.example.samplenewsarticle.apiresponse

import androidx.annotation.Keep
import retrofit2.Response

@Keep
sealed class ApiResult<out Success, out Failure>
data class ApiSuccess<out Success>(val value: Success) : ApiResult<Success, Nothing>()
data class ApiFailure<out Failure>(val failResponse: Failure) : ApiResult<Nothing, Failure>()

fun <T> Response<T>.toApiResult(): ApiResult<T?, ApiFailResponse> {
    return if (this.isSuccessful) {
        if (this.body() != null || this.code() == 204 || this.code() == 202) {
            ApiSuccess(this.body())
        } else {
            ApiFailure(this.toApiFailResponse())
        }
    } else {
        ApiFailure(this.toApiFailResponse())
    }
}

private fun <T> Response<T>.toApiFailResponse(): ApiFailResponse {
    return ApiFailResponse(
        response = this.raw(),
        errorBody = this.errorBody()
    )
}
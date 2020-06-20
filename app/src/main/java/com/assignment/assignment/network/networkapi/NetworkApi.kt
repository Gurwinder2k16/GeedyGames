package com.assignment.assignment.network.networkapi

import com.assignment.assignment.model.response.RedditResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("r/images/hot.json")
    fun downloadData(): Single<Response<RedditResponse>>
}


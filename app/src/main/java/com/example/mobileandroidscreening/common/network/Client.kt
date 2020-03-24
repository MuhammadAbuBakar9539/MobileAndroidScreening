package com.example.mobileandroidscreening.common.network

import com.example.mobileandroidscreening.common.USER_ENDPOINT
import com.example.mobileandroidscreening.common.USER_SEARCHER_ENDPOINT
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Client {
    @GET(USER_SEARCHER_ENDPOINT)
    suspend fun getUsersList(@Query("q") userName: String): UserSearcherModel

    @GET(USER_ENDPOINT)
    suspend fun getUser(@Path("user") userName: String): UserModel
}
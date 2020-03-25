package com.example.mobileandroidscreening.viewmodel.repository

import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import retrofit2.Response

interface UserSearcherRepository {
    suspend fun getUsersList(userName: String): Response<UserSearcherModel>
    suspend fun getUserDetail(userName: String?): Response<UserModel>
}
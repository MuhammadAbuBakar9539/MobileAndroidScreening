package com.example.mobileandroidscreening.viewmodel.repository

import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import io.reactivex.Single

interface UserSearcherRepository {
    suspend fun getUsersList(userName: String):UserSearcherModel
    suspend fun getNoOfRepos(userName: String):UserModel
}
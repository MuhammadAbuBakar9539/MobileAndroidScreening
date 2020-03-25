package com.example.mobileandroidscreening.viewmodel.repository

import com.example.mobileandroidscreening.common.network.Client
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import retrofit2.Response
import javax.inject.Inject

class UserSearcherRepositoryImpl @Inject constructor(private val client: Client):UserSearcherRepository {
    override suspend fun getUsersList(userName: String): Response<UserSearcherModel> {
        return client.getUsersList(userName)
    }

    override suspend fun getUserDetail(userName: String?): Response<UserModel> {
        return client.getUser(userName)
    }

    override suspend fun getUserRepos(userName: String?): Response<List<UserReposModel>> {
        return client.getUserRepos(userName)
    }

}
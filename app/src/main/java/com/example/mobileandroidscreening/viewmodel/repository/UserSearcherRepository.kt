package com.example.mobileandroidscreening.viewmodel.repository

import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import retrofit2.Response

interface UserSearcherRepository {

    suspend fun getUsersList(userName: String): UserSearcherModel

    suspend fun getUserDetail(userName: String?): UserModel

    suspend fun getUserRepos(userName: String?): List<UserReposModel>

    suspend fun getUsersListDb(userName: String): UserSearcherModel

    suspend fun addUsersList(userSearcher: UserSearcherModel)

    suspend fun getUserDb(userName: String): UserModel

    suspend fun addUser(user: UserModel)

    suspend fun getUserReposDb(userName: String): List<UserReposModel>

    suspend fun addUserRepos(userRepos: List<UserReposModel>)
}
package com.example.mobileandroidscreening.viewmodel.repository

import com.example.mobileandroidscreening.common.network.Client
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import com.example.mobileandroidscreening.model.db.AndroidScreeningDao
import retrofit2.Response
import javax.inject.Inject

class UserSearcherRepositoryImpl @Inject constructor(private val client: Client, private val androidScreeningDao: AndroidScreeningDao):UserSearcherRepository {
    override suspend fun getUsersList(userName: String): UserSearcherModel {
        return client.getUsersList(userName)
    }

    override suspend fun getUserDetail(userName: String?): UserModel {
        return client.getUser(userName)
    }

    override suspend fun getUserRepos(userName: String?): List<UserReposModel> {
        return client.getUserRepos(userName)
    }

    override suspend fun getUsersListDb(userName: String): UserSearcherModel {
        return androidScreeningDao.getUsersListDb(userName)
    }

    override suspend fun addUsersList(userSearcher: UserSearcherModel) {
        return androidScreeningDao.addUsersList(userSearcher)
    }

    override suspend fun getUserDb(userName: String): UserModel {
        return androidScreeningDao.getUserDb(userName)
    }

    override suspend fun addUser(user: UserModel) {
        return androidScreeningDao.addUser(user)
    }

    override suspend fun getUserReposDb(userName: String): List<UserReposModel> {
        return androidScreeningDao.getUserReposDb(userName)
    }

    override suspend fun addUserRepos(userRepos: List<UserReposModel>) {
        return androidScreeningDao.addUserRepos(userRepos)
    }

}
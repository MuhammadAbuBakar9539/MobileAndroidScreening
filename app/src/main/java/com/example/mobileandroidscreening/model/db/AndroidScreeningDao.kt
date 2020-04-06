package com.example.mobileandroidscreening.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel

@Dao
interface AndroidScreeningDao {
    @Query("SELECT * FROM tbl_user_searcher WHERE 'login'=:userName")
    suspend fun getUsersListDb(userName: String): UserSearcherModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUsersList(userSearcher: UserSearcherModel)

    @Query("SELECT * FROM tbl_user WHERE 'login'=:userName")
    suspend fun getUserDb(userName: String): UserModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserModel)

    @Query("SELECT * FROM tbl_user_repos WHERE 'login'=:userName")
    suspend fun getUserReposDb(userName: String): List<UserReposModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserRepos(userRepos: List<UserReposModel>)
}
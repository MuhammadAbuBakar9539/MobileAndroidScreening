package com.example.mobileandroidscreening.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_user_repos")
data class UserReposModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    val owner:List<Owner>
){
    @Entity
    data class Owner(
        @PrimaryKey(autoGenerate = true)
        val ownerId:Int,
        val login: String
    )
}
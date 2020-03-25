package com.example.mobileandroidscreening.model


import com.google.gson.annotations.SerializedName

data class UserReposModel(
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int
)
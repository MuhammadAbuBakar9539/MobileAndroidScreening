package com.example.mobileandroidscreening.model


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val bio: String?,
    @SerializedName("created_at")
    val createdAt: String,
    val email: String?,
    val followers: Int,
    val following: Int,
    val location: String?,
    val login: String
)
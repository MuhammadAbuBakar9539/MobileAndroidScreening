package com.example.mobileandroidscreening.model


import com.google.gson.annotations.SerializedName

data class UserSearcherModel(
    val items: List<Item>
) {
    data class Item(
        @SerializedName("avatar_url")
        val avatarUrl: String,
        val login: String
    )
}
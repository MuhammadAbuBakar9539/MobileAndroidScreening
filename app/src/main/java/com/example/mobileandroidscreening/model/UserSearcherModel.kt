package com.example.mobileandroidscreening.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class UserSearcherModel(
    val items: List<Item>
) {
    @Entity(tableName = "tbl_user_searcher")
    data class Item(
        @PrimaryKey(autoGenerate = true)
        val id:Int,
        @SerializedName("avatar_url")
        val avatarUrl: String,
        val login: String
    )
}
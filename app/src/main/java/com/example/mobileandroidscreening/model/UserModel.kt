package com.example.mobileandroidscreening.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_user")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
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
package com.example.mobileandroidscreening.model.db

import androidx.room.TypeConverter
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class ListConverter {
    private var gson: Gson = Gson()

    /*@TypeConverter
    fun userSearcherList(data: String?): List<UserSearcherModel.Item> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<UserSearcherModel.Item?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun userSearcherListToString(userSearcherOwner: List<UserSearcherModel.Item?>?): String {
        return gson.toJson(userSearcherOwner)
    }*/

    @TypeConverter
    fun userReposList(data: String?): List<UserReposModel.Owner> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<UserReposModel.Owner?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun userReposListToString(userReposOwner: List<UserReposModel.Owner?>?): String {
        return gson.toJson(userReposOwner)
    }
}
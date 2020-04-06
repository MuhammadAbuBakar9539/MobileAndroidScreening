package com.example.mobileandroidscreening.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel

@Database(
    entities = [UserModel::class, UserReposModel::class, UserSearcherModel.Item::class],
    version = 1
)
@TypeConverters(ListConverter::class)
abstract class AndroidScreeningDatabase : RoomDatabase() {
    abstract fun androidScreeningDao(): AndroidScreeningDao
}
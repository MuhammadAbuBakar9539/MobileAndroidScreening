package com.example.mobileandroidscreening.di.module

import android.app.Application
import androidx.room.Room
import com.example.mobileandroidscreening.model.db.AndroidScreeningDao
import com.example.mobileandroidscreening.model.db.AndroidScreeningDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidScreeningDatabaseModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideDatabase():AndroidScreeningDatabase{
        return Room.databaseBuilder(
            application.applicationContext,
            AndroidScreeningDatabase::class.java,
            "Android_Screening_Database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(androidScreeningDatabase: AndroidScreeningDatabase):AndroidScreeningDao{
        return androidScreeningDatabase.androidScreeningDao()
    }
}

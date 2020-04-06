package com.example.mobileandroidscreening.di.component

import com.example.mobileandroidscreening.MyApp
import com.example.mobileandroidscreening.common.network.Client
import com.example.mobileandroidscreening.di.module.AndroidScreeningDatabaseModule
import com.example.mobileandroidscreening.di.module.NetworkModule
import com.example.mobileandroidscreening.model.db.AndroidScreeningDao
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, AndroidScreeningDatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject(myApp: MyApp)
    fun client(): Client
    fun androidScreeningDao(): AndroidScreeningDao
}
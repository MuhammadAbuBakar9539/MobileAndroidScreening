package com.example.mobileandroidscreening

import android.app.Application
import com.example.mobileandroidscreening.di.component.AppComponent
import com.example.mobileandroidscreening.di.component.DaggerAppComponent
import com.example.mobileandroidscreening.di.module.NetworkModule

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        component().inject(this)
    }

    fun component():AppComponent{
        return DaggerAppComponent.builder().networkModule(NetworkModule()).build()
    }
}
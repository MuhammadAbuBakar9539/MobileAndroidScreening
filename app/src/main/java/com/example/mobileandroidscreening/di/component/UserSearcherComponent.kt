package com.example.mobileandroidscreening.di.component

import com.example.mobileandroidscreening.di.module.UserSearcherModule
import com.example.mobileandroidscreening.di.scope.ActivityScope
import com.example.mobileandroidscreening.view.SearcherActivity
import dagger.Component

@Component(modules = [UserSearcherModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface UserSearcherComponent {
    fun inject(searcherActivity: SearcherActivity)
}
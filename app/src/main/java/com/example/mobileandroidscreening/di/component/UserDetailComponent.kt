package com.example.mobileandroidscreening.di.component

import com.example.mobileandroidscreening.di.module.UserDetailModule
import com.example.mobileandroidscreening.di.scope.ActivityScope
import com.example.mobileandroidscreening.view.UserDetailActivity
import dagger.Component

@Component(modules = [UserDetailModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface UserDetailComponent {
    fun inject(userDetailActivity: UserDetailActivity)
}
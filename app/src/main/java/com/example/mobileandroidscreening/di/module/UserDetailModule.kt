package com.example.mobileandroidscreening.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.mobileandroidscreening.common.network.Client
import com.example.mobileandroidscreening.di.scope.ActivityScope
import com.example.mobileandroidscreening.view.UserDetailActivity
import com.example.mobileandroidscreening.viewmodel.UserSearcherViewModel
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepository
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepositoryImpl
import com.example.mobileandroidscreening.viewmodel.viewmodelfactory.UserSearcherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UserDetailModule(private val userDetailActivity: UserDetailActivity) {
    @Provides
    @ActivityScope
    fun provideViewModelFactory(repository: UserSearcherRepository): UserSearcherViewModelFactory {
        return UserSearcherViewModelFactory(
            repository
        )
    }

    @Provides
    @ActivityScope
    fun provideViewModel(factory: UserSearcherViewModelFactory): UserSearcherViewModel {
        return ViewModelProvider(userDetailActivity, factory).get(UserSearcherViewModel::class.java)
    }

    @Provides
    @ActivityScope
    fun provideRepository(client: Client): UserSearcherRepository {
        return UserSearcherRepositoryImpl(
            client
        )
    }
}
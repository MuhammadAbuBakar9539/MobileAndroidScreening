package com.example.mobileandroidscreening.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.mobileandroidscreening.common.network.Client
import com.example.mobileandroidscreening.di.scope.ActivityScope
import com.example.mobileandroidscreening.model.db.AndroidScreeningDao
import com.example.mobileandroidscreening.view.SearcherActivity
import com.example.mobileandroidscreening.viewmodel.UserSearcherViewModel
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepository
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepositoryImpl
import com.example.mobileandroidscreening.viewmodel.viewmodelfactory.UserSearcherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UserSearcherModule(private val searcherActivity: SearcherActivity) {
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
        return ViewModelProvider(searcherActivity, factory).get(UserSearcherViewModel::class.java)
    }

    @Provides
    @ActivityScope
    fun provideRepository(client: Client, androidScreeningDao: AndroidScreeningDao): UserSearcherRepository {
        return UserSearcherRepositoryImpl(
            client, androidScreeningDao
        )
    }
}
package com.example.mobileandroidscreening.viewmodel.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobileandroidscreening.viewmodel.UserSearcherViewModel
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class UserSearcherViewModelFactory @Inject constructor(private val repository: UserSearcherRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserSearcherViewModel(repository) as T
    }
}
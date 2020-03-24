package com.example.mobileandroidscreening.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mobileandroidscreening.model.UserSearcherModel
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepository
import kotlinx.coroutines.Dispatchers

class UserSearcherViewModel(private val repository: UserSearcherRepository):ViewModel() {
    private val usersListObservable = MutableLiveData<UserSearcherModel>()

    fun getUsersList(userName:String):LiveData<UserSearcherModel>{
        return liveData(Dispatchers.IO){
            emit(repository.getUsersList(userName))
        }
    }

    fun usersListObservable(): LiveData<UserSearcherModel>{
        return usersListObservable
    }
}
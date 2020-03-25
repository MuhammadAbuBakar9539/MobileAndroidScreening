package com.example.mobileandroidscreening.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response

class UserSearcherViewModel(private val repository: UserSearcherRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val usersListObservable = MutableLiveData<UserSearcherModel>()
    private val usersListErrorObservable = MutableLiveData<String>()
    private val userObservable = MutableLiveData<UserModel>()
    private val userErrorObservable = MutableLiveData<String>()
    private val userReposObservable = MutableLiveData<List<UserReposModel>>()
    private val userReposErrorObservable = MutableLiveData<String>()

    fun getUsersList(userName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getUsersList(userName)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        usersListObservable.value = response.body()
                    } else {
                        usersListErrorObservable.value = response.message()
                    }
                } catch (e: HttpException) {
                    usersListErrorObservable.value = e.message()
                } catch (e: Throwable) {
                    usersListErrorObservable.value = e.message
                }
            }
        }
    }

    fun getUser(userName: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getUserDetail(userName)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        userObservable.value = response.body()
                    } else {
                        userErrorObservable.value = response.message()
                    }
                } catch (e: HttpException) {
                    userErrorObservable.value = e.message()
                } catch (e: Throwable) {
                    userErrorObservable.value = e.message
                }
            }
        }
    }

    fun getUserRepos(userName: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getUserRepos(userName)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        userReposObservable.value = response.body()
                    } else {
                        userReposErrorObservable.value = response.message()
                    }
                } catch (e: HttpException) {
                    userReposErrorObservable.value = e.message()
                } catch (e: Throwable) {
                    userReposErrorObservable.value = e.message
                }
            }
        }
    }

    fun usersListObservable(): LiveData<UserSearcherModel> {
        return usersListObservable
    }

    fun usersListErrorObservable(): LiveData<String> {
        return usersListErrorObservable
    }

    fun userObservable(): LiveData<UserModel> {
        return userObservable
    }

    fun userErrorObservable(): LiveData<String> {
        return userErrorObservable
    }

    fun userReposObservable(): LiveData<List<UserReposModel>> {
        return userReposObservable
    }

    fun userReposErrorObservable(): LiveData<String> {
        return userReposErrorObservable
    }
}
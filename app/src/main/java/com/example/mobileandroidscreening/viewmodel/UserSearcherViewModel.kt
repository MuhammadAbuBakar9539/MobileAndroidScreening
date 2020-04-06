package com.example.mobileandroidscreening.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.model.UserSearcherModel
import com.example.mobileandroidscreening.viewmodel.repository.UserSearcherRepository
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.math.sin

class UserSearcherViewModel(private val repository: UserSearcherRepository) : ViewModel() {
    private val usersListObservable = MutableLiveData<UserSearcherModel>()
    private val usersListErrorObservable = MutableLiveData<String>()
    private val userObservable = MutableLiveData<UserModel>()
    private val userErrorObservable = MutableLiveData<String>()
    private val userReposObservable = MutableLiveData<List<UserReposModel>>()
    private val userReposErrorObservable = MutableLiveData<String>()
    private lateinit var userSearcherResponse: UserSearcherModel
    private lateinit var singleItem:UserSearcherModel


    fun getUsersList(userName: String, connected: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            userSearcherResponse = if (connected) {
                repository.getUsersList(userName)
            } else {
                repository.getUsersListDb(userName)
            }
            withContext(Dispatchers.Main) {
                try {
                    if (connected) {
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val list =UserSearcherModel.Item(1, "klj.png", "a")
                                singleItem= UserSearcherModel(listOf(list))
                                repository.addUsersList(singleItem)
                            } catch (e: Exception) {
                                Log.i("hope", e.message.toString())
                            }
                        }
                    }
                    usersListObservable.value = userSearcherResponse
                } catch (e: Exception) {
                    usersListErrorObservable.value = e.message
                } catch (e: HttpException) {
                    usersListErrorObservable.value = e.message
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
                    userObservable.value = response
                } catch (e: Exception) {
                    userErrorObservable.value = e.message
                } catch (e: HttpException) {
                    userErrorObservable.value = e.message
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
                    userReposObservable.value = response
                } catch (e: Exception) {
                    userReposErrorObservable.value = e.message
                } catch (e: HttpException) {
                    userReposErrorObservable.value = e.message
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
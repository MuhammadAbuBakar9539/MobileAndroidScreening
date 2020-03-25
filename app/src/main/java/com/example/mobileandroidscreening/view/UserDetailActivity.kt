package com.example.mobileandroidscreening.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileandroidscreening.MyApp
import com.example.mobileandroidscreening.R
import com.example.mobileandroidscreening.common.INTENT_KEY
import com.example.mobileandroidscreening.di.component.DaggerUserDetailComponent
import com.example.mobileandroidscreening.di.module.UserDetailModule
import com.example.mobileandroidscreening.model.UserModel
import com.example.mobileandroidscreening.viewmodel.UserSearcherViewModel
import kotlinx.android.synthetic.main.activity_user_detail.*
import javax.inject.Inject

class UserDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: UserSearcherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        DaggerUserDetailComponent.builder().appComponent((application as MyApp).component())
            .userDetailModule(UserDetailModule(this))
            .build().inject(this)

        val userName = intent.getStringExtra(INTENT_KEY)

        viewModel.getUser(userName)

        viewModel.userObservable().observe(this, Observer {userDetail->
            rv_user_detail.layoutManager = LinearLayoutManager(this)
            //rv_user_detail.adapter =
        })


    }
}

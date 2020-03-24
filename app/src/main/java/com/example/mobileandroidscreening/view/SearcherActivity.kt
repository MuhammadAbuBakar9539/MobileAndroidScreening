package com.example.mobileandroidscreening.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileandroidscreening.MyApp
import com.example.mobileandroidscreening.R
import com.example.mobileandroidscreening.di.component.DaggerUserSearcherComponent
import com.example.mobileandroidscreening.di.module.UserSearcherModule
import com.example.mobileandroidscreening.view.recyclerview.UserSearchAdapter
import com.example.mobileandroidscreening.viewmodel.UserSearcherViewModel
import kotlinx.android.synthetic.main.activity_searcher.*
import javax.inject.Inject

class SearcherActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: UserSearcherViewModel

    private lateinit var userName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searcher)

        DaggerUserSearcherComponent.builder().appComponent((application as MyApp).component())
            .userSearcherModule(UserSearcherModule(this))
            .build().inject(this)

        userName = et_user_search

        et_user_search.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s?.length !=0){
                    viewModel.getUsersList(s.toString())
                }else{
                    //rv_users.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        if (userName.text != null){
            viewModel.usersListObservable().observe(this, Observer { searchedUsers->
                //rv_users.visibility = View.VISIBLE
                rv_users.layoutManager = LinearLayoutManager(this)
                rv_users.adapter = UserSearchAdapter(searchedUsers)
            })
        }
    }
}

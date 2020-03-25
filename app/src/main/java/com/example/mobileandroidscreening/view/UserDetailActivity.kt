package com.example.mobileandroidscreening.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileandroidscreening.MyApp
import com.example.mobileandroidscreening.R
import com.example.mobileandroidscreening.common.INTENT_KEY
import com.example.mobileandroidscreening.common.createToast
import com.example.mobileandroidscreening.common.loadImage
import com.example.mobileandroidscreening.di.component.DaggerUserDetailComponent
import com.example.mobileandroidscreening.di.module.UserDetailModule
import com.example.mobileandroidscreening.model.UserReposModel
import com.example.mobileandroidscreening.view.recyclerview.OnReposRecyclerViewItemClicked
import com.example.mobileandroidscreening.view.recyclerview.UserReposAdapter
import com.example.mobileandroidscreening.viewmodel.UserSearcherViewModel
import kotlinx.android.synthetic.main.activity_user_detail.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class UserDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: UserSearcherViewModel

    private lateinit var userReposList: List<UserReposModel>

    private lateinit var adapter: UserReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        DaggerUserDetailComponent.builder().appComponent((application as MyApp).component())
            .userDetailModule(UserDetailModule(this))
            .build().inject(this)

        val userName = intent.getStringExtra(INTENT_KEY)

        viewModel.getUser(userName)
        et_user_repository_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        viewModel.getUserRepos(userName)

        viewModel.userObservable().observe(this, Observer { userDetail ->
            loadImage(userDetail.avatarUrl, img_user_detail)
            tv_user_detail_username.text = userDetail.login
            tv_user_detail_email.text = userDetail.email
            tv_user_detail_location.text = userDetail.location
            tv_user_detail_join_date.text = userDetail.createdAt
        })

        viewModel.userReposObservable().observe(this, Observer { userRepos ->
            userReposList = userRepos
            adapter = UserReposAdapter(userReposList, object:OnReposRecyclerViewItemClicked{
                override fun onRepoItemClicked(repoLink: String) {
                    startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(repoLink))
                    )
                }
            })
            rv_user_repositories.layoutManager = LinearLayoutManager(this)
            rv_user_repositories.adapter = adapter
        })

        viewModel.userErrorObservable().observe(this, Observer { error ->
            createToast(error)
        })

    }

    private fun filter(text: String) {
        val filteredList:MutableList<UserReposModel> = ArrayList()
        for (item in userReposList){
            if (item.fullName.toLowerCase(Locale.getDefault())
                    .contains(text.toLowerCase(Locale.getDefault()).trim())){
                filteredList.add(item)
            }
        }
        adapter.filterList(filteredList)
    }
}

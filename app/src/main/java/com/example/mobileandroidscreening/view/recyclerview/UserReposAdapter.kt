package com.example.mobileandroidscreening.view.recyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileandroidscreening.R
import com.example.mobileandroidscreening.common.inflate
import com.example.mobileandroidscreening.model.UserReposModel
import kotlinx.android.synthetic.main.user_repositories.view.*

class UserReposAdapter(var userRepos: List<UserReposModel>):RecyclerView.Adapter<UserReposAdapter.UserViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewModel {
        return UserViewModel(parent.inflate(R.layout.user_repositories))
    }

    override fun getItemCount(): Int {
        return userRepos.size
    }

    override fun onBindViewHolder(holder: UserViewModel, position: Int) {
        holder.repoName.text = userRepos[position].fullName
        holder.forks.text = userRepos[position].forksCount.toString()
        holder.stars.text = userRepos[position].stargazersCount.toString()
    }

    class UserViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoName: TextView = itemView.tv_repository_name
        val forks: TextView = itemView.tv_no_of_forks
        val stars: TextView = itemView.tv_no_of_stars
    }

    fun filterList(filteredList: MutableList<UserReposModel>){
        userRepos = filteredList
        notifyDataSetChanged()
    }
}
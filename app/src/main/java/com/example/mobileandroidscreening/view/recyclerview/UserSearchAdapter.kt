package com.example.mobileandroidscreening.view.recyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileandroidscreening.R
import com.example.mobileandroidscreening.common.inflate
import com.example.mobileandroidscreening.common.loadImage
import com.example.mobileandroidscreening.model.UserSearcherModel
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.search_user_item.view.*

class UserSearchAdapter(
    private val userList: UserSearcherModel,
    private val onUserRecyclerViewItemClicked: OnUserRecyclerViewItemClicked
) :
    RecyclerView.Adapter<UserSearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(parent.inflate(R.layout.search_user_item))
    }

    override fun getItemCount(): Int {
        return userList.items.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        loadImage(userList.items[position].avatarUrl, holder.avatarImage)
        holder.username.text = userList.items[position].login
        //holder.numberOfRepositories.text = user.publicRepos.toString()

        holder.bind(userList.items[position].login)
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImage: CircleImageView = itemView.img_search_user
        val username: TextView = itemView.tv_search_user_username
        val numberOfRepositories: TextView = itemView.tv_search_user_no_of_repositories

        fun bind(userName: String) {
            itemView.setOnClickListener {
                onUserRecyclerViewItemClicked.onUserItemClicked(userName)
            }
        }
    }
}
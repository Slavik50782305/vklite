package com.vklite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FeedAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<FeedAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val author: TextView =
            view.findViewById(R.id.postAuthor)

        val text: TextView =
            view.findViewById(R.id.postText)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_post,
                parent,
                false
            )

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        val post = posts[position]

        holder.author.text = post.author
        holder.text.text = post.text
    }

    override fun getItemCount() = posts.size
}

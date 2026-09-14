package com.vklite

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FeedAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<FeedAdapter.PostViewHolder>() {

    class PostViewHolder(
        val textView: TextView
    ) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {

        val tv = TextView(parent.context)
        tv.textSize = 18f
        tv.setPadding(32, 32, 32, 32)

        return PostViewHolder(tv)
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        val post = posts[position]

        holder.textView.text =
            "${post.author}\n\n${post.text}"
    }

    override fun getItemCount() = posts.size
}

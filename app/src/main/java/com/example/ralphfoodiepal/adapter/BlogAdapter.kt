// BlogAdapter.kt
package com.example.ralphfoodiepal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.data.BlogPost

class BlogAdapter(private val blogPosts: List<BlogPost>) :
    RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_blog_post, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blogPost = blogPosts[position]
        holder.bind(blogPost)
    }

    override fun getItemCount(): Int {
        return blogPosts.size
    }

    class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textBlogTitle)
        private val contentTextView: TextView = itemView.findViewById(R.id.textBlogContent)
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewBlog)

        fun bind(blogPost: BlogPost) {
            titleTextView.text = blogPost.title
            contentTextView.text = blogPost.content
            imageView.setImageResource(blogPost.imageResId)
        }
    }
}

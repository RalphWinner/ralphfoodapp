// AddBlogPostFragment.kt
package com.example.ralphfoodiepal.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.data.BlogPost

class AddBlogPostFragment : Fragment() {

    private var onBlogPostAddedListener: ((BlogPost) -> Unit)? = null

    fun setOnBlogPostAddedListener(listener: (BlogPost) -> Unit) {
        onBlogPostAddedListener = listener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_blog_post, container, false)
    }

    private fun onSaveBlogPost() {
        // Your logic to save the blog post
        val newBlogPost = BlogPost("New Blog Post Title", "New Blog Post Content", R.drawable.default_blog_image)
        // Notify the listener when a new blog post is added
        onBlogPostAddedListener?.invoke(newBlogPost)
        fragmentManager?.popBackStack()
    }
}

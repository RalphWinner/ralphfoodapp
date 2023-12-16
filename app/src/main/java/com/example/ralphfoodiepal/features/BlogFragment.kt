// BlogFragment.kt
package com.example.ralphfoodiepal.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.adapter.BlogAdapter
import com.example.ralphfoodiepal.data.BlogPost

class BlogFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var blogAdapter: BlogAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        // Initialize RecyclerView and its adapter
        recyclerView = view.findViewById(R.id.recyclerViewBlog)
        blogAdapter = BlogAdapter(getSampleBlogPosts()) // Provide your list of blog posts here

        // Set up RecyclerView with a LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = blogAdapter

        return view
    }

    // Sample data for testing
    private fun getSampleBlogPosts(): List<BlogPost> {
        val posts = mutableListOf<BlogPost>()

        val post = BlogPost("Ralph With The Perfect Pasta Recipe", "Pasta, a timeless classic in the world of culinary delights, holds a special place in every food enthusiast's heart. Achieving the perfect al dente texture and rich flavors is an art, and we're here to guide you through the steps to create a plate of pasta perfection. Begin by choosing high-quality pasta and a sauce that complements your taste buds. Boil the pasta in well-salted water until it reaches that ideal firmness, and then toss it generously in your chosen sauce. Whether you prefer a classic marinara, a creamy Alfredo, or a zesty pesto, the key lies in balancing flavors and allowing the pasta to absorb the essence of the sauce. Top it off with a sprinkle of Parmesan and fresh herbs, and you're ready to savor a bowl of homemade goodness.", R.drawable.pasta_blog_image)
        val post2 = BlogPost("Ralph With The Perfect Pasta Recipe", "Eggs, a versatile and nutritious kitchen staple, offer endless possibilities for culinary creativity. Achieving the perfect balance between a silky yolk and firm whites requires a delicate touch and a bit of patience. For a classic sunny-side-up, gently crack the egg into a hot, buttered pan, allowing the edges to crisp while keeping the yolk runny. If you fancy a velvety scramble, whisk eggs with a touch of milk and cook them low and slow, stirring gently until they form soft curds. Poached eggs, a breakfast delicacy, involve simmering the egg in swirling water until the whites set but the yolk remains gloriously liquid. Whether boiled, fried, scrambled, or poached, mastering the art of cooking eggs opens the door to a world of delightful breakfasts and quick, satisfying meals.", R.drawable.eggs_blog_image)
        posts.add(post)
        posts.add(post2)

        // Add sample blog posts
//        for (i in 1..4) {
//            val post = BlogPost("Title $i", "Content of blog post $i", R.drawable.default_blog_image)
//            posts.add(post)
//        }

        return posts
    }
}

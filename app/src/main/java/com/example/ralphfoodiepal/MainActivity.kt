package com.example.ralphfoodiepal

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ralphfoodiepal.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.example.ralphfoodiepal.features.AboutMeFragment
import com.example.ralphfoodiepal.features.BlogFragment
import com.example.ralphfoodiepal.features.ContactFragment
import com.example.ralphfoodiepal.features.MealPlannerFragment
import com.example.ralphfoodiepal.features.RecipesFragment
import com.example.ralphfoodiepal.features.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Check if the user is not logged in
        if (!isUserLoggedIn()) {
            // Initialize fragment transaction
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            // Replace the fragment container with LoginFragment
            transaction.replace(R.id.fragmentContainer, LoginFragment())

            // Commit the transaction
            transaction.commit()

            // Stop the execution of the rest of onCreate if not logged in
            return
        }

        // Continue with the rest of the initialization if the user is logged in
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        // Initialize the adapter
        adapter = ViewPagerAdapter(supportFragmentManager)

        // Add all fragments initially
        adapter.addFragment(RecipesFragment(), "Recipes")
        adapter.addFragment(MealPlannerFragment(), "Meal Planner")
        adapter.addFragment(BlogFragment(), "Blog")
        adapter.addFragment(ContactFragment(), "Contact")
        adapter.addFragment(AboutMeFragment(), "About Me")

        // Set up the ViewPager with the adapter
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("user_prefs", AppCompatActivity.MODE_PRIVATE)
        return sharedPreferences.getBoolean("is_logged_in", false)
    }
}

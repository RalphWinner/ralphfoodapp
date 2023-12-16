package com.example.ralphfoodiepal.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ralphfoodiepal.features.AboutMeFragment
import com.example.ralphfoodiepal.features.BlogFragment
import com.example.ralphfoodiepal.features.ContactFragment
import com.example.ralphfoodiepal.features.MealPlannerFragment
import com.example.ralphfoodiepal.features.RecipesFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = listOf(
        RecipesFragment(),
        MealPlannerFragment(),
        BlogFragment(),
        ContactFragment(),
        AboutMeFragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Return titles for tabs
        return when (position) {
            0 -> "Recipes"
            1 -> "Meal Planner"
            2 -> "Blog"
            3 -> "Contact"
            4 -> "About Me"
            else -> null
        }
    }
}

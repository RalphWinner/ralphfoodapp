// MealPlannerFragment.kt
package com.example.ralphfoodiepal.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.adapter.MealPlanAdapter
import com.example.ralphfoodiepal.adapter.MealPlannerAdapter
import com.example.ralphfoodiepal.data.DayHeader
import com.example.ralphfoodiepal.data.MealPlan
import com.example.ralphfoodiepal.data.MealPlannerItem
import com.google.android.material.floatingactionbutton.FloatingActionButton

// MealPlannerFragment.kt
class MealPlannerFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAddMealPlan: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewMealPlans)
        fabAddMealPlan = view.findViewById(R.id.fabAddMealPlan)

        // Set up RecyclerView
        val items = getDummyMealPlannerItems() // Replace with your actual data
        val adapter = MealPlannerAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // Set up FloatingActionButton click listener
        fabAddMealPlan.setOnClickListener {
            // Handle click to add a new meal plan (you can show a dialog or navigate to a new screen)
            Toast.makeText(context, "Add Meal Plan Clicked", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    // Replace this function with your actual data source
    private fun getDummyMealPlannerItems(): List<MealPlannerItem> {
        return listOf(
            MealPlannerItem.DayHeaderItem(DayHeader("Monday")),
            MealPlannerItem.MealPlanItem(MealPlan("Monday", "Breakfast: Scrambled Eggs")),
            MealPlannerItem.MealPlanItem(MealPlan("Monday", "Lunch: Chicken Salad")),
            MealPlannerItem.DayHeaderItem(DayHeader("Tuesday")),
            MealPlannerItem.MealPlanItem(MealPlan("Tuesday", "Dinner: Spaghetti Bolognese")),
            // Add more items as needed
        )
    }
}

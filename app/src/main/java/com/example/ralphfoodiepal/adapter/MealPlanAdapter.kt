package com.example.ralphfoodiepal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.data.MealPlan

// MealPlanAdapter.kt
class MealPlanAdapter(private val mealPlans: List<MealPlan>) :
    RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_meal_plan, parent, false)
        return MealPlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealPlanViewHolder, position: Int) {
        val mealPlan = mealPlans[position]
        holder.bind(mealPlan)
    }

    override fun getItemCount(): Int {
        return mealPlans.size
    }

    class MealPlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mealPlan: MealPlan) {
            val dayOfWeekTextView: TextView = itemView.findViewById(R.id.textDayOfWeek)
            val mealTextView: TextView = itemView.findViewById(R.id.textMeal)

            dayOfWeekTextView.text = mealPlan.dayOfWeek
            mealTextView.text = mealPlan.meal
        }
    }
}

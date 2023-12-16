package com.example.ralphfoodiepal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.data.DayHeader
import com.example.ralphfoodiepal.data.MealPlan
import com.example.ralphfoodiepal.data.MealPlannerItem

// MealPlannerAdapter.kt
class MealPlannerAdapter(private val items: List<MealPlannerItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // View types
    private val VIEW_TYPE_MEAL_PLAN = 0
    private val VIEW_TYPE_DAY_HEADER = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_MEAL_PLAN -> {
                val view = inflater.inflate(R.layout.item_meal_plan, parent, false)
                MealPlanViewHolder(view)
            }
            VIEW_TYPE_DAY_HEADER -> {
                val view = inflater.inflate(R.layout.item_day_header, parent, false)
                DayHeaderViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is MealPlanViewHolder -> {
                val mealPlanItem = item as MealPlannerItem.MealPlanItem
                holder.bind(mealPlanItem.mealPlan)
            }
            is DayHeaderViewHolder -> {
                val dayHeaderItem = item as MealPlannerItem.DayHeaderItem
                holder.bind(dayHeaderItem.dayHeader)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is MealPlannerItem.MealPlanItem -> VIEW_TYPE_MEAL_PLAN
            is MealPlannerItem.DayHeaderItem -> VIEW_TYPE_DAY_HEADER
        }
    }

    // ViewHolder for MealPlanItem
    class MealPlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mealPlan: MealPlan) {
            // Bind data to views in the item layout
            val dayOfWeekTextView: TextView = itemView.findViewById(R.id.textDayOfWeek)
            val mealTextView: TextView = itemView.findViewById(R.id.textMeal)

            dayOfWeekTextView.text = mealPlan.dayOfWeek
            mealTextView.text = mealPlan.meal
        }
    }

    // ViewHolder for DayHeaderItem
    class DayHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dayHeader: DayHeader) {
            // Bind data to views in the item layout
            val dayOfWeekTextView: TextView = itemView.findViewById(R.id.textDayOfWeekHeader)
            dayOfWeekTextView.text = dayHeader.dayOfWeek
        }
    }
}

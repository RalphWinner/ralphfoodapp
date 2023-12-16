package com.example.ralphfoodiepal.data

// MealPlannerItem.kt
sealed class MealPlannerItem {
    data class MealPlanItem(val mealPlan: MealPlan) : MealPlannerItem()
    data class DayHeaderItem(val dayHeader: DayHeader) : MealPlannerItem()
}

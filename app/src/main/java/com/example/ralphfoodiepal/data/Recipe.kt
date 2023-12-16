package com.example.ralphfoodiepal.data

// Recipe.kt
data class Recipe(
    val name: String,
    val cookingTime: String,
    val rating: Float,
    val imageUrl: Int,
    val instructions: String // New field for instructions
)

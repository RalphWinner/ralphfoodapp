// RecipesFragment.kt
package com.example.ralphfoodiepal.features

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.adapter.RecipeAdapter
import com.example.ralphfoodiepal.data.Recipe
import com.google.android.material.floatingactionbutton.FloatingActionButton

// RecipesFragment.kt
class RecipesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAddRecipe: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewRecipes)
        fabAddRecipe = view.findViewById(R.id.fabAddRecipe)

        // Set up RecyclerView
        val recipes = getDummyRecipes() // Replace with your actual data
        val adapter = RecipeAdapter(recipes)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // Set up FloatingActionButton click listener
        fabAddRecipe.setOnClickListener {
            // Handle click to add a new recipe (you can navigate to a new screen or show a dialog)
            showAddRecipeDialog()
        }

        return view
    }

    private fun showAddRecipeDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_recipe, null)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setTitle("Add New Recipe")

        val alertDialog = dialogBuilder.create()

        val editTextRecipeName: EditText = dialogView.findViewById(R.id.editTextRecipeName)
        val editTextCookingTime: EditText = dialogView.findViewById(R.id.editTextCookingTime)
        val ratingBar: RatingBar = dialogView.findViewById(R.id.ratingBar)
        val editTextInstructions: EditText = dialogView.findViewById(R.id.editTextInstructions)
        val btnAddRecipe: Button = dialogView.findViewById(R.id.btnAddRecipe)

        btnAddRecipe.setOnClickListener {
            // Get user inputs
            val recipeName = editTextRecipeName.text.toString()
            val cookingTime = editTextCookingTime.text.toString()
            val rating = ratingBar.rating
            val instructions = editTextInstructions.text.toString()

            // Validate inputs
            if (recipeName.isNotEmpty() && cookingTime.isNotEmpty() && instructions.isNotEmpty()) {
                // Default imageUrl for the new recipe (you can customize this)
                val defaultImageUrl = R.drawable.recipe_4

                // Create a new recipe
                val newRecipe = Recipe(recipeName, cookingTime, rating, defaultImageUrl, instructions)

                // Add the new recipe to the existing list
                val updatedRecipes = mutableListOf(newRecipe)
                updatedRecipes.addAll(getDummyRecipes())

                // Update the RecyclerView with the new list of recipes
                recyclerView.adapter = RecipeAdapter(updatedRecipes)

                alertDialog.dismiss()
            } else {
                // Show a message if any field is empty
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        alertDialog.show()
    }

    // Replace this function with your actual data source
    private fun getDummyRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Pasta Carbonara",
                "30 minutes",
                4.5f,
                R.drawable.recipe_1,
                "1. Cook spaghetti according to package instructions.\n2. In a pan, cook bacon until crispy.\n3. Mix cooked spaghetti with beaten eggs, grated cheese, and bacon.\n4. Serve immediately."
            ),
            Recipe(
                "Chicken Alfredo",
                "45 minutes",
                4.2f,
                R.drawable.recipe_2,
                "1. Cook fettuccine according to package instructions.\n2. In a pan, cook chicken until fully cooked.\n3. Mix cooked fettuccine with alfredo sauce and cooked chicken.\n4. Garnish with parsley and serve."
            ),
            Recipe(
                "Vegetable Stir-Fry",
                "20 minutes",
                4.0f,
                R.drawable.recipe_3,
                "1. Heat oil in a wok.\n2. Stir-fry mixed vegetables until tender-crisp.\n3. Add soy sauce and stir.\n4. Serve over rice."
            )// Add more recipes as needed
        )
    }
}

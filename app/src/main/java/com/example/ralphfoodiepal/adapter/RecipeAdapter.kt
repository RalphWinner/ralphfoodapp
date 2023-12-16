package com.example.ralphfoodiepal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ralphfoodiepal.R
import com.example.ralphfoodiepal.data.Recipe

class RecipeAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)

        // Add a divider for all items except the last one
        if (position < recipes.size - 1) {
            holder.dividerView.visibility = View.VISIBLE
        } else {
            holder.dividerView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImageView: ImageView = itemView.findViewById(R.id.imageViewRecipe)
        val nameTextView: TextView = itemView.findViewById(R.id.textRecipeName)
        val timeTextView: TextView = itemView.findViewById(R.id.textCookingTime)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val instructionsTextView: TextView = itemView.findViewById(R.id.textInstructions)
        val dividerView: View = itemView.findViewById(R.id.divider)

        fun bind(recipe: Recipe) {
            // Bind data to views in the item layout
            recipeImageView.setImageResource(recipe.imageUrl)
            nameTextView.text = recipe.name
            timeTextView.text = recipe.cookingTime
            ratingBar.rating = recipe.rating
            instructionsTextView.text = recipe.instructions
        }
    }
}

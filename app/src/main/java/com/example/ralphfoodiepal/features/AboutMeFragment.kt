// AboutMeFragment.kt
package com.example.ralphfoodiepal.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.ralphfoodiepal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class AboutMeFragment : Fragment() {

    private lateinit var fabAddDetails: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)

        // Initialize views
        fabAddDetails = view.findViewById(R.id.fabAddDetails)

        // Set up click listener for fabAddDetails
        fabAddDetails.setOnClickListener {
            // TODO: Implement logic to add new details dynamically
            showSnackbar("Adding new details!")
        }

        // Set dynamic details about the app creator
        view.findViewById<TextView>(R.id.textName).text = "Ralph DEUS"
        view.findViewById<TextView>(R.id.textBio).text = "Proactive .NET/C# developer with around 5 years of professional experience in software development. "

        // Dynamic details
        view.findViewById<TextView>(R.id.textCulinaryJourney).text = "Culinary Journey: details..."
        view.findViewById<TextView>(R.id.textFavoriteRecipes).text = "Favorite Recipes: recipes..."
        view.findViewById<TextView>(R.id.textFoodPhilosophy).text = "Food Philosophy: food philosophy..."

        // Set up Logout button click listener
        val btnLogout: Button = view.findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            logout()
        }

        return view
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }
    // New method for logout
    fun logout() {
        // Delete login status from SharedPreferences
        deleteLoginStatus()

        // Navigate back to the login page
        navigateToLoginFragment()
    }

    private fun deleteLoginStatus() {
        val sharedPreferences = requireActivity().getSharedPreferences("user_prefs", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("is_logged_in")
        editor.apply()
    }

    private fun navigateToLoginFragment() {
        fragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer, LoginFragment())
            ?.commit()
    }
}

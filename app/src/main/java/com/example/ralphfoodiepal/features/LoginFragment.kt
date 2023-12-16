package com.example.ralphfoodiepal.features

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.ralphfoodiepal.MainActivity
import com.example.ralphfoodiepal.R

class LoginFragment : Fragment() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize UI components
        editTextUsername = view.findViewById(R.id.editTextUsername)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        btnLogin = view.findViewById(R.id.btnLogin)

        // Set click listener for the login button
        btnLogin.setOnClickListener {
            onLoginClick()
        }

        return view
    }

    private fun onLoginClick() {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()

        // Simulate a successful login (replace this with your actual login logic)
        if (isValidLogin(username, password)) {
            // Save login status using SharedPreferences
            saveLoginStatus(true)

            // Navigate to the main part of your app
            navigateToMainActivity()
        } else {
            Toast.makeText(requireContext(), "Login informations are not correct", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveLoginStatus(isLoggedIn: Boolean) {
        val sharedPreferences = requireActivity().getSharedPreferences("user_prefs", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("is_logged_in", isLoggedIn)
        editor.apply()
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        // Implement your actual login validation logic here
        // For example, you might check against a hardcoded username and password
        return username == "ralph" && password == "ralph1234"
    }

    private fun navigateToMainActivity() {
        // Launch the MainActivity
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)

        // Finish the current activity (LoginFragment)
        requireActivity().finish()
    }
}

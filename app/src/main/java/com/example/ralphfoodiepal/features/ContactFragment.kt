// ContactFragment.kt
package com.example.ralphfoodiepal.features

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ralphfoodiepal.R
import com.google.android.material.button.MaterialButton

class ContactFragment : Fragment() {

    private lateinit var btnCallChef: MaterialButton
    private lateinit var btnEmailChef: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        // Initialize buttons
        btnCallChef = view.findViewById(R.id.btnCallChef)
        btnEmailChef = view.findViewById(R.id.btnEmailChef)

        // Set click listeners
        btnCallChef.setOnClickListener { callChef() }
        btnEmailChef.setOnClickListener { emailChef() }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Fragment is attached to an activity, you can access the activity using 'context'
    }

    private fun callChef() {
        if (!isAdded) return // Check if the fragment is attached

        val phoneNumber = "tel:+16418192484"
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
        requireActivity().startActivity(dialIntent)
    }

    private fun emailChef() {
        if (!isAdded) return // Check if the fragment is attached

        val email = "deusralph97@gmail.com"
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
        requireActivity().startActivity(emailIntent)
    }
}

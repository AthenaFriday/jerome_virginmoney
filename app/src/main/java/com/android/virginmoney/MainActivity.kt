package com.android.virginmoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.virginmoney.ui.people.PeopleFragment
import com.android.virginmoney.ui.rooms.RoomsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)  // Make sure you set the layout

        // Check which layout to load
        if (savedInstanceState == null) {
            // Start with PeopleFragment or RoomsFragment based on your logic
            val fragment = PeopleFragment() // You can replace this with RoomsFragment() if needed
            showFragment(fragment)
        }
    }

    // Helper function to replace the fragment
    private fun showFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)  // Use fragment_container instead of fragment_people
            .commit()
    }

    // You can add a function to switch fragments dynamically
    fun switchToRoomsFragment() {
        val roomsFragment = RoomsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, roomsFragment)  // Replace in the correct container (fragment_container)
            .addToBackStack(null) // Optional: This allows you to navigate back to the previous fragment
            .commit()
    }
}

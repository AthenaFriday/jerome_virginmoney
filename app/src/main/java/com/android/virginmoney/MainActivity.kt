package com.android.virginmoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.virginmoney.R
import com.android.virginmoney.ui.people.PeopleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This is your layout with the fragment container

        if (savedInstanceState == null) {
            // Only add the fragment if it is not being restored from a previous instance
            val fragment = PeopleFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)  // R.id.fragment_container is the container in activity_main.xml
                .commit()
        }
    }
}

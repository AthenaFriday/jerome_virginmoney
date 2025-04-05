package com.android.virginmoney


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.virginmoney.R
import com.android.virginmoney.ui.people.PeopleFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openPeopleFragment()
        }
    }

    private fun openPeopleFragment() {
        replaceFragment(PeopleFragment())
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

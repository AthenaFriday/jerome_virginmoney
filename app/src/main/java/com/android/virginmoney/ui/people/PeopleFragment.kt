package com.android.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.virginmoney.R
import android.util.Log

class PeopleFragment : Fragment() {

    private val TAG = "PeopleFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false)
    }
}

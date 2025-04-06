package com.android.virginmoney.ui.people

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.android.virginmoney.R
import com.android.virginmoney.viewmodel.PeopleViewModel

class PeopleActivity : AppCompatActivity() {
    private lateinit var viewModel: PeopleViewModel
    private lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        viewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        adapter = PeopleAdapter { person ->
            // Handle click event to show person details
        }

        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
        viewModel.fetchPeople()
        viewModel.people.observe(this) { people ->
            adapter.submitList(people)
        }
    }
}

package com.android.virginmoney.ui.rooms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.android.virginmoney.R
import com.android.virginmoney.viewmodel.RoomsViewModel

class RoomsActivity : AppCompatActivity() {
    private lateinit var viewModel: RoomsViewModel
    private lateinit var adapter: RoomsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)

        viewModel = ViewModelProvider(this).get(RoomsViewModel::class.java)
        adapter = RoomsAdapter()

        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
        viewModel.fetchRooms()
        viewModel.rooms.observe(this) { rooms ->
            adapter.submitList(rooms)
        }
    }
}

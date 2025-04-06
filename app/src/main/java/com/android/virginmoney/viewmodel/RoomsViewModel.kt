package com.android.virginmoney.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.virginmoney.data.RoomRepository
import com.android.virginmoney.data.model.Room
import kotlinx.coroutines.launch

class RoomsViewModel(private val repository: RoomRepository) : ViewModel() {

    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms

    fun fetchRooms() {
        viewModelScope.launch {
            try {
                val roomList = repository.getRooms()
                _rooms.value = roomList
            } catch (e: Exception) {
                // Handle error
                _rooms.value = emptyList()
            }
        }
    }
}

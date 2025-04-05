package com.android.virginmoney.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.virginmoney.data.ApiService
import com.android.virginmoney.data.model.Person
import com.android.virginmoney.data.model.Room
import kotlinx.coroutines.launch

class DirectoryViewModel(private val apiService: ApiService) : ViewModel() {

    private val _people = MutableLiveData<List<Person>>()
    val people: LiveData<List<Person>> get() = _people

    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms

    fun fetchPeople() {
        viewModelScope.launch {
            _people.value = apiService.getPeople()
        }
    }

    fun fetchRooms() {
        viewModelScope.launch {
            _rooms.value = apiService.getRooms()
        }
    }
}

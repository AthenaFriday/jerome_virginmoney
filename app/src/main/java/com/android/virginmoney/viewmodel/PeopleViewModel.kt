package com.android.virginmoney.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.virginmoney.data.PersonRepository
import com.android.virginmoney.data.model.Person
import kotlinx.coroutines.launch

class PeopleViewModel(private val repository: PersonRepository) : ViewModel() {

    private val _people = MutableLiveData<List<Person>>()
    val people: LiveData<List<Person>> get() = _people

    fun fetchPeople() {
        viewModelScope.launch {
            try {
                val personList = repository.getPeople()
                _people.value = personList
            } catch (e: Exception) {
                // Handle error
                _people.value = emptyList()
            }
        }
    }
}

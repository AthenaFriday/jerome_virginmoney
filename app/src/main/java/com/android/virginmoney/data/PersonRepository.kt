package com.android.virginmoney.data

import com.android.virginmoney.data.model.Person

class PersonRepository(private val apiService: ApiService) {
    suspend fun getPeople(): List<Person> {
        return apiService.getPeople()
    }
}

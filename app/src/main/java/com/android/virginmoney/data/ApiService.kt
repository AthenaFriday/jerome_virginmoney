package com.android.virginmoney.data

import com.android.virginmoney.data.model.Person
import com.android.virginmoney.data.model.Room
import retrofit2.http.GET

    interface ApiService {
        @GET("people")
        suspend fun getPeople(): List<Person>

        @GET("rooms")
        suspend fun getRooms(): List<Room>
    }

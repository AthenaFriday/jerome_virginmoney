package com.android.virginmoney.data

import com.android.virginmoney.data.model.Room


class RoomRepository(private val apiService: ApiService) {
    suspend fun getRooms(): List<Room> {
        return apiService.getRooms()
    }
}

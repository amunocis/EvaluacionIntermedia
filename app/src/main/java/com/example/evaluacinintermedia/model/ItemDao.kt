package com.example.evaluacinintermedia.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {

    suspend fun insertItem()
}
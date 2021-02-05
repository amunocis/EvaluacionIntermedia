package com.example.evaluacinintermedia.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllItems(listItem: List<ItemEntity>)

    @Update
    suspend fun updateItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)

    @Query("DELETE FROM item_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM item_table ORDER BY id DESC")
    fun getAllItem(): LiveData<List<ItemEntity>>

    @Query("SELECT * FROM item_table WHERE nombre = :nombre LIMIT 1")
    fun getItemByName(nombre: String): LiveData<ItemEntity>

    @Query("SELECT * FROM item_table WHERE id = :id")
    fun getItemByID(id: Int): LiveData<ItemEntity>
}
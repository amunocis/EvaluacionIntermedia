package com.example.evaluacinintermedia.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.evaluacinintermedia.model.ItemDataBase
import com.example.evaluacinintermedia.model.ItemEntity
import com.example.evaluacinintermedia.model.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ItemRepository
    val allItem: LiveData<List<ItemEntity>>

    init {
        val itemDao = ItemDataBase.getDataBase(application).getItemDao()
        repository = ItemRepository(itemDao)
        allItem = repository.listAllItem
    }

    fun insertTask(item: ItemEntity) = viewModelScope.launch {
        repository.insertItem(item)
    }

    fun updateTask(item: ItemEntity) = viewModelScope.launch {
        repository.updateItem(item)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun getTaskById(id: Int): LiveData<ItemEntity> {
        return repository.getItemByID(id)
    }
}
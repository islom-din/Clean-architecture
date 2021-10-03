package com.example.cleanarch.presentation

import androidx.lifecycle.ViewModel
import com.example.cleanarch.data.ToDoListRepositoryImpl
import com.example.cleanarch.domain.*

class MainViewModel : ViewModel() {

    private val repository = ToDoListRepositoryImpl
    private val getToDoItemListUseCase = GetToDoItemListUseCase(repository)
    private val deleteToDoItemUseCase = DeleteToDoItemUseCase(repository)
    private val editToDoItemUseCase = EditToDoItemUseCase(repository)

    val toDoItemListLD = getToDoItemListUseCase.getToDoItems()

    fun deleteToDoItem(toDoItem: ToDoItem) {
        deleteToDoItemUseCase.deleteToDoItem(toDoItem)
    }

    fun changeEnableState(toDoItem: ToDoItem) {
        val newItem = toDoItem.copy(enabled = !toDoItem.enabled)
        editToDoItemUseCase.editToDoItem(newItem)
    }

}
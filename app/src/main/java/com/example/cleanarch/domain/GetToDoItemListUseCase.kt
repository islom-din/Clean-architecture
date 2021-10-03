package com.example.cleanarch.domain

import androidx.lifecycle.LiveData

class GetToDoItemListUseCase (
    private val toDoListRepository: ToDoListRepository
) {
    fun getToDoItems(): LiveData<List<ToDoItem>> {
        return toDoListRepository.getToDoItems()
    }
}
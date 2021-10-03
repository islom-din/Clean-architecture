package com.example.cleanarch.domain

class AddToDoItemUseCase (
    private val toDoListRepository: ToDoListRepository
) {
    fun addToDoItem(toDoItem: ToDoItem) {
        toDoListRepository.addToDoItem(toDoItem)
    }
}
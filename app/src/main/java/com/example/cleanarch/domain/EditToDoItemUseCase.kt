package com.example.cleanarch.domain

class EditToDoItemUseCase (
    private val toDoListRepository: ToDoListRepository
) {
    fun editToDoItem(toDoItem: ToDoItem) {
        toDoListRepository.editToDoItem(toDoItem)
    }
}
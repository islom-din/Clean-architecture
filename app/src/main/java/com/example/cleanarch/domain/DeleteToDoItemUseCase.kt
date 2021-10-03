package com.example.cleanarch.domain

class DeleteToDoItemUseCase (
    private val toDoListRepository: ToDoListRepository
) {
    fun deleteToDoItem(toDoItem: ToDoItem) {
         toDoListRepository.deleteToDoItem(toDoItem)
    }
}
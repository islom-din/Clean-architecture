package com.example.cleanarch.domain

class GetToDoItemUseCase (
    private val toDoListRepository: ToDoListRepository
) {
    fun getToDoItem(id: Int): ToDoItem {
        return toDoListRepository.getToDoItem(id)
    }
}
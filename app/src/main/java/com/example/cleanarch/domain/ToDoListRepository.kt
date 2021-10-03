package com.example.cleanarch.domain

import androidx.lifecycle.LiveData

interface ToDoListRepository {

    fun addToDoItem(toDoItem: ToDoItem)

    fun deleteToDoItem(toDoItem: ToDoItem)

    fun editToDoItem(toDoItem: ToDoItem)

    fun getToDoItems(): LiveData<List<ToDoItem>>

    fun getToDoItem(id: Int): ToDoItem
}
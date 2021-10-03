package com.example.cleanarch.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarch.domain.ToDoItem
import com.example.cleanarch.domain.ToDoListRepository
import java.lang.RuntimeException

object ToDoListRepositoryImpl : ToDoListRepository {

    private val toDoList: MutableList<ToDoItem> = mutableListOf()
    private var autoIncrementId = 0
    private val toDoListLD = MutableLiveData<List<ToDoItem>>()

    init {
        for(i in 0 until 10) {
            val item = ToDoItem("$i", true)
            addToDoItem(item)
        }
    }

    override fun addToDoItem(toDoItem: ToDoItem) {
        if(toDoItem.id == ToDoItem.UNDEFINED_ID ) {
            toDoItem.id = autoIncrementId++
        }
        toDoList.add(toDoItem)
        updateToDoListLD()
    }

    override fun deleteToDoItem(toDoItem: ToDoItem) {
        toDoList.remove(toDoItem)
        updateToDoListLD()
    }

    override fun editToDoItem(toDoItem: ToDoItem) {
        val oldElement = getToDoItem(toDoItem.id)
        toDoList.remove(oldElement)
        addToDoItem(toDoItem)
    }

    override fun getToDoItems(): LiveData<List<ToDoItem>> = toDoListLD

    override fun getToDoItem(id: Int): ToDoItem = toDoList.find { it.id == id }
        ?: throw RuntimeException()

    private fun updateToDoListLD() {
        toDoListLD.value = toDoList.toList()
    }
}
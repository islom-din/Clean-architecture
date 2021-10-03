package com.example.cleanarch.domain

data class ToDoItem(
    val name: String,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}

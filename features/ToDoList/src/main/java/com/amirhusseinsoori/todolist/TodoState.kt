package com.amirhusseinsoori.todolist


import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.todolist.component.base.State

data class TodoState(
    val tooDoList: List<TodoModel> = emptyList()
): State
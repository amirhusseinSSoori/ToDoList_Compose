package com.amirhusseinsoori.domain.repository

import com.amirhusseinsoori.domain.entity.TodoModel

interface InsertToDoRepository {
    suspend fun insertToDoList(todoModel: TodoModel)
}
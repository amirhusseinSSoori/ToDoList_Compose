package com.amirhusseinsoori.domain.repository

import com.amirhusseinsoori.domain.entity.TodoModel

interface DeleteToDoRepository {
    suspend fun deleteToDoList(todoModel: TodoModel)
}
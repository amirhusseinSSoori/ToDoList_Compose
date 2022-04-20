package com.amirhusseinsoori.domain.repository

import com.amirhusseinsoori.domain.entity.TodoModel
import kotlinx.coroutines.flow.Flow

interface GetAllToDoListRepository {
    fun getAllToDoList(): Flow<List<TodoModel>>
}
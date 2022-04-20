package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.db.dao.ToDoDao
import com.amirhusseinsoori.data.db.model.ToDoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val local: ToDoDao) {

    fun getAllToDoList(): Flow<List<ToDoEntity>> = local.getListToDoList()

    suspend fun insertToDoList(toDoEntity: ToDoEntity) {
        local.insertTodo(toDoEntity)
    }

    suspend fun deleteToDoList(toDoEntity: ToDoEntity) {
        local.delete(toDoEntity)
    }
}
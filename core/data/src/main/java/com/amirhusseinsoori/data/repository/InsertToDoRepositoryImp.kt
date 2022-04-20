package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.db.dao.ToDoDao
import com.amirhusseinsoori.data.mapper.mapToDoEntity
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.InsertToDoRepository
import javax.inject.Inject

class InsertToDoRepositoryImp @Inject constructor(private val local: ToDoDao) :
    InsertToDoRepository {
    override suspend fun insertToDoList(todoModel: TodoModel) {
        local.insert(todoModel.mapToDoEntity())
    }
}
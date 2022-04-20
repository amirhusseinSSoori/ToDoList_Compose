package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.db.dao.ToDoDao
import com.amirhusseinsoori.data.mapper.mapToDoEntity
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.DeleteToDoRepository
import javax.inject.Inject

class DeleteToDoRepositoryImp @Inject constructor(private val local: ToDoDao) :
    DeleteToDoRepository {
    override suspend fun deleteToDoList(todoModel: TodoModel) {
        local.delete(todoModel.mapToDoEntity())
    }
}
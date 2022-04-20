package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.db.dao.ToDoDao
import com.amirhusseinsoori.data.mapper.mapFlowListToDoModel
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllToDoListRepositoryImp @Inject constructor(private val local: ToDoDao) :
    GetAllToDoListRepository {
    override fun getAllToDoList(): Flow<List<TodoModel>> =
        local.getListToDoList().mapFlowListToDoModel()

}
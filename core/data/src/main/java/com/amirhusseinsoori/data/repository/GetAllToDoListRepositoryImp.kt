package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.ToDoEntityQueries
import com.amirhusseinsoori.data.mapper.mapFlowListToToDoModel
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllToDoListRepositoryImp @Inject constructor(
    private val toDoEntityQueries: ToDoEntityQueries) :
    GetAllToDoListRepository {
    override fun getAllToDoList(): Flow<List<TodoModel>> =
        toDoEntityQueries.selectAll().mapFlowListToToDoModel()

}
package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.ToDoEntityQueries
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.DeleteToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteToDoRepositoryImp @Inject constructor(private val toDoEntityQueries: ToDoEntityQueries) :
    DeleteToDoRepository {
    override suspend fun deleteToDoList(todoModel: TodoModel) {
        todoModel.run {
            withContext(Dispatchers.IO) {
                toDoEntityQueries
                    .deleteById(todoModel.id?:0)
            }
        }
    }
}
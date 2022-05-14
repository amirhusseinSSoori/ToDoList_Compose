package com.amirhusseinsoori.data.repository


import com.amirhusseinsoori.data.ToDoEntityQueries
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.InsertToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class InsertToDoRepositoryImp @Inject constructor(private val toDoEntityQueries: ToDoEntityQueries) :
    InsertToDoRepository {
    override suspend fun insertToDoList(todoModel: TodoModel) {
        todoModel.run {
            withContext(Dispatchers.IO) {
                toDoEntityQueries
                    .insert(
                        title = title ?: "",
                        description = description ?: "",
                        date = Calendar.getInstance().time.toString(
                        )
                    )
            }
        }
    }
}
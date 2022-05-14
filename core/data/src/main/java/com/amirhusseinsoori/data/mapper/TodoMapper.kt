package com.amirhusseinsoori.data.mapper

import com.amirhusseinsoori.data.ToDoEntity
import com.amirhusseinsoori.domain.entity.TodoModel
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map




fun Query<ToDoEntity>.mapFlowListToToDoModel(): Flow<List<TodoModel>> {
    return this.asFlow().map { todo->
        todo.executeAsList()
    }.map {
        it.mapListToDoModel()
    }
}



fun List<ToDoEntity>.mapListToDoModel(): List<TodoModel> {
    return map { it.mapToDoModel() }
}

fun ToDoEntity.mapToDoModel(): TodoModel {
    return TodoModel(
        id = id,
        title = title ?: "",
        description = description ?: "",
        date = date ?: ""
    )

}



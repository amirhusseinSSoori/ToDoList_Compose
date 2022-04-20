package com.amirhusseinsoori.data.mapper

import com.amirhusseinsoori.data.db.model.ToDoEntity
import com.amirhusseinsoori.domain.entity.TodoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun Flow<List<ToDoEntity>>.mapFlowListToDoModel(): Flow<List<TodoModel>> {
    return map {
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

fun TodoModel.mapToDoEntity(): ToDoEntity {
    return ToDoEntity(
        id = id,
        title = title ?: "",
        description = description ?: "",
        date = date ?: ""
    )

}

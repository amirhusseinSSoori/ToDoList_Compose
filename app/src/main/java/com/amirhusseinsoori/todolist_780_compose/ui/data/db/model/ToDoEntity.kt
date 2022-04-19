package com.amirhusseinsoori.todolist_780_compose.ui.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "toDoEntity")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val Description: String? = null
)
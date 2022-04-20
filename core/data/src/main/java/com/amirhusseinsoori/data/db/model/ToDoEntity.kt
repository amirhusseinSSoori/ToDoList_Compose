package com.amirhusseinsoori.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "toDoEntity")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val date: String? = Calendar.getInstance().time.toString(),

    )
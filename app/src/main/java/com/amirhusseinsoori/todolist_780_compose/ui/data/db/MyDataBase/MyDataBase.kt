package com.amirhusseinsoori.todolist_780_compose.ui.data.db.MyDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.todolist_780_compose.ui.data.db.dao.ToDoDao
import com.amirhusseinsoori.todolist_780_compose.ui.data.db.model.ToDoEntity

@Database(
    entities = [ToDoEntity::class],
    version = 1
)
abstract class MyDataBase : RoomDatabase() {
    abstract fun toDoListDao(): ToDoDao
}
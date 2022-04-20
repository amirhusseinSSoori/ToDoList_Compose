package com.amirhusseinsoori.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.data.db.dao.ToDoDao
import com.amirhusseinsoori.data.db.model.ToDoEntity

@Database(
    entities = [ToDoEntity::class],
    version = 1
)
abstract class MyDataBase : RoomDatabase() {
    abstract fun toDoListDao(): ToDoDao
}
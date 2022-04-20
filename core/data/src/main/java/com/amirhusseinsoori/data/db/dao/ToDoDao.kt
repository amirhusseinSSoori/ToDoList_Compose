package com.amirhusseinsoori.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.amirhusseinsoori.data.db.model.ToDoEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class ToDoDao : BaseDao<ToDoEntity> {
    @Query("SELECT * FROM toDoEntity")
    abstract fun getListToDoList(): Flow<List<ToDoEntity>>
}
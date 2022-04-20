package com.amirhusseinsoori.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.amirhusseinsoori.data.db.model.ToDoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDoEntity")
    fun getListToDoList(): Flow<List<ToDoEntity>>


    @Delete
    suspend fun delete(toDoEntity: ToDoEntity)


    @Insert
    suspend fun insertTodo(toDoEntity: ToDoEntity)

}
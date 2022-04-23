package com.amirhusseinsoori.data.db.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amirhusseinsoori.data.db.DBHelper
import com.amirhusseinsoori.data.db.MyDataBase
import com.amirhusseinsoori.data.db.model.ToDoEntity
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ToDoDaoTest : TestCase() {


    private lateinit var db: MyDataBase
    private lateinit var toDoDao: ToDoDao

    @Before
    fun setup() {
        db = DBHelper.getInMemoryDb()
        toDoDao = db.toDoListDao()
    }


    @Test
    fun writeAndReadFromMyDataBase() = runBlocking {
        val entity = ToDoEntity(id = 1, title = "amir", description = "developer")
        toDoDao.insert(entity)
        val list = toDoDao.getListToDoList().first()
        assertThat(list.contains(entity)).isTrue()

    }


    @Test
    fun deleteEntity() = runBlocking {
        val entity = ToDoEntity(id = 1, title = "amir", description = "developer")
        toDoDao.insert(entity)
        toDoDao.delete(entity)
        val list = toDoDao.getListToDoList().first()
        assertTrue(list.isEmpty())
    }


    @After
    fun teardown() {
        db.close()
    }
}
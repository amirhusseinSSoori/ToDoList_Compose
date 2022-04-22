package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import com.amirhusseinsoori.domain.repository.InsertToDoRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class InsertToDoUseCaseTest {
    private lateinit var useCase: InsertToDoUseCase
    private val mockRepository = Mockito.mock(InsertToDoRepository::class.java)
    @Before
    fun setup() {
        useCase = InsertToDoUseCase(mockRepository)
    }

    @Test
    fun insertToDoItems() {
        runBlocking {
            launch {
                val input = TodoModel()
                useCase.execute(input)
                Mockito.verify(mockRepository).insertToDoList(input)
                this.cancel()
            }
            return@runBlocking
        }
    }
}
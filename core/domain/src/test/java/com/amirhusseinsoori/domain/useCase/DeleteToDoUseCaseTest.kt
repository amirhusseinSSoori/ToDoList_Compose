package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.DeleteToDoRepository
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class DeleteToDoUseCaseTest {
    private lateinit var useCase: DeleteToDoUseCase
    private val mockRepository = Mockito.mock(DeleteToDoRepository::class.java)

    @Before
    fun setup() {
        useCase = DeleteToDoUseCase(mockRepository)
    }

    @Test
    fun deleteToDoListItems() {
        runBlocking {
            launch {
                val input = TodoModel()
                useCase.execute(input)
                Mockito.verify(mockRepository).deleteToDoList(input)
                this.cancel()
            }
            return@runBlocking
        }
    }
}
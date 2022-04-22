package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ShowAllToDoListUseCaseTest {
    private lateinit var useCase: ShowAllToDoListUseCase
    private val mockRepository = Mockito.mock(GetAllToDoListRepository::class.java)
    @Before
    fun setup() {
        useCase = ShowAllToDoListUseCase(mockRepository)
    }

    @Test
    fun getShowAllMovie() {
        runBlocking {
            launch {
                useCase.execute()
                Mockito.verify(mockRepository).getAllToDoList()
                this.cancel()
            }
            return@runBlocking
        }
    }
}
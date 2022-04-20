package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import com.amirhusseinsoori.domain.useCase.base.UseCaseImmediate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowAllToDoListUseCase @Inject constructor(val repository: GetAllToDoListRepository) :
    UseCaseImmediate<Flow<List<TodoModel>>>() {
    override fun buildUseCaseImmediate(): Flow<List<TodoModel>> {
        return repository.getAllToDoList()
    }
}
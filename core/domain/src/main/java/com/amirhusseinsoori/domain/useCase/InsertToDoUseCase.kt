package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.InsertToDoRepository
import com.amirhusseinsoori.domain.useCase.base.UseCaseWithParamsImmediate
import javax.inject.Inject

class InsertToDoUseCase @Inject constructor(val repository: InsertToDoRepository) :
    UseCaseWithParamsImmediate<TodoModel, Unit>() {
    override suspend fun buildUseCaseImmediate(params: TodoModel) {
        repository.insertToDoList(params)
    }
}
package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.DeleteToDoRepository
import com.amirhusseinsoori.domain.useCase.base.UseCaseWithParamsImmediate
import javax.inject.Inject

class DeleteToDoUseCase @Inject constructor(val repository: DeleteToDoRepository) :
    UseCaseWithParamsImmediate<TodoModel, Unit>() {
    override suspend fun buildUseCaseImmediate(params: TodoModel) {
        repository.deleteToDoList(params)
    }
}
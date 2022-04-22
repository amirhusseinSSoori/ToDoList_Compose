package com.amirhusseinsoori.todolist

import androidx.lifecycle.viewModelScope

import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.useCase.DeleteToDoUseCase
import com.amirhusseinsoori.domain.useCase.ShowAllToDoListUseCase
import com.amirhusseinsoori.todolist.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val showAllToDoListUseCase: ShowAllToDoListUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase
) : BaseViewModel<TodoEvent, TodoState>() {

    init {
        handleEvent(TodoEvent.ShowAllToDoList)
    }

    override fun createInitialState(): TodoState = TodoState()

    override fun handleEvent(handleEvent: TodoEvent) {
        when (handleEvent) {
            is TodoEvent.DeleteItemToDo -> {
                deleteTodoList(handleEvent.todoModel)
            }
            TodoEvent.ShowAllToDoList -> {
                getAllList()
            }
        }
    }

    private fun getAllList() {
        viewModelScope.launch {
            showAllToDoListUseCase.execute().collect() { list ->
                state.value = TodoState(tooDoList = list)
            }
        }
    }

    private fun deleteTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            deleteToDoUseCase.execute(todoModel)
        }
    }


}

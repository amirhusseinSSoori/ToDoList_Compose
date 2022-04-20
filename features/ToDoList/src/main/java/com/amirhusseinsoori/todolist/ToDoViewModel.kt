package com.amirhusseinsoori.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.useCase.DeleteToDoUseCase
import com.amirhusseinsoori.domain.useCase.InsertToDoUseCase
import com.amirhusseinsoori.domain.useCase.ShowAllToDoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val showAllToDoListUseCase: ShowAllToDoListUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase,
    private val insertToDoUseCase: InsertToDoUseCase
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<List<TodoModel>>(emptyList())
    val stateFlow = mutableStateFlow.asStateFlow()

    init {
        eventGetList()
    }


    private fun eventGetList() {
        viewModelScope.launch {
            showAllToDoListUseCase.execute().collect() {
                mutableStateFlow.value = it
            }
        }
    }


    fun insertTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            insertToDoUseCase.execute(todoModel)
        }
    }

    fun deleteTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            deleteToDoUseCase.execute(todoModel)
        }
    }
}
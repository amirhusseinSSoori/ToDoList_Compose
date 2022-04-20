package com.amirhusseinsoori.todolist_780_compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.data.db.model.ToDoEntity
import com.amirhusseinsoori.data.repository.Repository
import com.amirhusseinsoori.domain.entity.TodoModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<List<TodoModel>>(emptyList())
    val stateFlow = mutableStateFlow.asStateFlow()

    init {
        eventGetList()
    }


    private fun eventGetList() {
        viewModelScope.launch {
            repository.getAllToDoList().collect() {
                mutableStateFlow.value = it
            }
        }
    }


    fun insertTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            repository.insertToDoList(todoModel)
        }
    }

    fun deleteTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            repository.deleteToDoList(todoModel)
        }
    }
}
package com.amirhusseinsoori.todolist_780_compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.data.db.model.ToDoEntity
import com.amirhusseinsoori.data.repository.Repository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<List<ToDoEntity>>(emptyList())
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


    fun insertTodoList(toDoEntity: ToDoEntity) {
        viewModelScope.launch {
            repository.insertToDoList(toDoEntity)
        }
    }

    fun deleteTodoList(toDoEntity: ToDoEntity) {
        viewModelScope.launch {
            repository.deleteToDoList(toDoEntity)
        }
    }
}
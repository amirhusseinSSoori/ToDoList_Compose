package com.amirhusseinsoori.todolist_780_compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.data.repository.GetAllToDoListRepositoryImp
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.repository.DeleteToDoRepository
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import com.amirhusseinsoori.domain.repository.InsertToDoRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val getAllToDoListRepository: GetAllToDoListRepository,
    private val deleteToDoRepository: DeleteToDoRepository,
    private val insertToDoRepository: InsertToDoRepository
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<List<TodoModel>>(emptyList())
    val stateFlow = mutableStateFlow.asStateFlow()

    init {
        eventGetList()
    }


    private fun eventGetList() {
        viewModelScope.launch {
            getAllToDoListRepository.getAllToDoList().collect() {
                mutableStateFlow.value = it
            }
        }
    }


    fun insertTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            insertToDoRepository.insertToDoList(todoModel)
        }
    }

    fun deleteTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            deleteToDoRepository.deleteToDoList(todoModel)
        }
    }
}
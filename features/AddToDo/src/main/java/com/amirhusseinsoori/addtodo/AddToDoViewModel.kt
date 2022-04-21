package com.amirhusseinsoori.addtodo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.domain.useCase.InsertToDoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddToDoViewModel @Inject constructor(private val insertToDoUseCase: InsertToDoUseCase) :
    ViewModel() {

    var title by mutableStateOf("")
    var des by mutableStateOf("")


    fun insertTodoList(todoModel: TodoModel) {
        viewModelScope.launch {
            insertToDoUseCase.execute(todoModel)
        }
    }
}
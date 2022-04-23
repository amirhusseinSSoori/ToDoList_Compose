package com.amirhusseinsoori.showtodo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.amirhusseinsoori.domain.entity.TodoModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowToDoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, gson: Gson
) : ViewModel() {
    var todoModelState by mutableStateOf(TodoModel())

    init {
        gson.fromJson(savedStateHandle.get<String>("details"), TodoModel::class.java)?.let {
            todoModelState = it
        }
    }
}


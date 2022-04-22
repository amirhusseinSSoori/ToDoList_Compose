package com.amirhusseinsoori.todolist.component.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<event : Event, state : State> : ViewModel() {
    abstract fun createInitialState(): state
    private val initialState: state by lazy { createInitialState() }
    val currentState: state
        get() = _state.value

    val state: MutableStateFlow<state> = MutableStateFlow(initialState)
    val _state = state.asStateFlow()
    abstract fun handleEvent(handleEvent: event)
}
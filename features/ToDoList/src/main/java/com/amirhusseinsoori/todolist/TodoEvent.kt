package com.amirhusseinsoori.todolist



import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.todolist.component.base.Event

sealed class TodoEvent : Event {
    object ShowAllToDoList : TodoEvent()
    data class DeleteItemToDo(var todoModel: TodoModel) : TodoEvent()
}

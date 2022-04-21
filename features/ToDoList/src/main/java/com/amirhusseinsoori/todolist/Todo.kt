package com.amirhusseinsoori.todolist

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amirhusseinsoori.common.ScreenRoute
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.todolist.component.SwipeToDeleteItems
import com.amirhusseinsoori.todolist.component.TodoItemList
import com.amirhusseinsoori.todolist.component.red


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun TodoScreen(navController: NavController, viewModel: ToDoViewModel) {
    val list = viewModel.stateFlow.collectAsState()
    Column {
        Button(
            onClick = {
                navController.navigate(ScreenRoute.AddDetails.route)
            },
            modifier = Modifier
        ) {
            Text(text = "ADD")
        }
        LazyColumn {
            items(list.value, { todo: TodoModel -> todo.id!! }) { item ->
                SwipeToDeleteItems(
                    endToStart = { viewModel.deleteTodoList(item) },
                    startToEnd = { viewModel.deleteTodoList(item) },
                    showItems = {
                        TodoItemList(item = item)
                    })
            }
        }
    }
}

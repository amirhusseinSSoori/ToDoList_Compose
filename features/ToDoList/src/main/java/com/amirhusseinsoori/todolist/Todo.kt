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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDeleteItems(
    endToStart: () -> Unit,
    startToEnd: () -> Unit,
    showItems: @Composable () -> Unit
) {
    val dismissState = rememberDismissState()
    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
        endToStart()
    } else if (dismissState.isDismissed(DismissDirection.StartToEnd)) {
        startToEnd()
    }
    SwipeToDismiss(
        state = dismissState,
        modifier = Modifier
            .padding(vertical = Dp(1f)),
        directions = setOf(
            DismissDirection.EndToStart,
            DismissDirection.StartToEnd
        ),
        dismissThresholds = { direction ->
            FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.05f)
        },
        background = {
            val color by animateColorAsState(
                when (dismissState.targetValue) {
                    DismissValue.Default -> Color.White
                    else -> Color.Red
                }
            )
            val alignment = Alignment.CenterEnd
            val icon = Icons.Default.Delete
            val scale by animateFloatAsState(
                if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
            )

            Box(
                Modifier
                    .fillMaxSize()
                    .background(color)
                    .padding(horizontal = Dp(20f)),
                contentAlignment = alignment
            ) {
                Icon(
                    icon,
                    contentDescription = "Delete Icon",
                    modifier = Modifier.scale(scale)
                )
            }
        },
        dismissContent = {
            showItems()
        }
    )
}


@Composable
fun TodoItemList(item: TodoModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = item.title ?: "",
                textAlign = TextAlign.Center,
                color = red
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(5.dp),
                text = "description : ".plus(item.description),
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), text = item.date ?: "",
                textAlign = TextAlign.End,
                fontSize = 9.sp
            )
        }
    }
}
package com.amirhusseinsoori.todolist_780_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.todolist_780_compose.ui.ToDoViewModel
import com.amirhusseinsoori.todolist_780_compose.ui.data.db.model.ToDoEntity
import com.amirhusseinsoori.todolist_780_compose.ui.theme.ToDoList_780_ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

var id: Int = 0

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ToDoViewModel = hiltViewModel()
            ToDoList_780_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(viewModel: ToDoViewModel) {
    val list=viewModel.stateFlow.collectAsState()
    Column {
        Button(
            onClick = {

                viewModel.insertTodoList(toDoEntity = ToDoEntity(title = "SDFdsf",Description = "Asdasdasdasd"))
            },
            modifier = Modifier
        ) {
            Text(text = "ADD")
        }
        LazyColumn {
            items(list.value, { todo: ToDoEntity -> todo.id!! }) { item ->
                val dismissState = rememberDismissState()
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {



                    viewModel.deleteTodoList(item)
                }
                SwipeToDismiss(
                    state = dismissState,
                    modifier = Modifier
                        .padding(vertical = Dp(1f)),
                    directions = setOf(
                        DismissDirection.EndToStart
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
                        TodoItemList(item = item)
                    }
                )
                Divider(Modifier.fillMaxWidth(), Color.DarkGray)
            }
        }
    }
}


@Composable
fun TodoItemList(item: ToDoEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = "title : ".plus(item.title),
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(5.dp),
                text = "description : ",
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), text = "date time",
                textAlign = TextAlign.End
            )
        }
    }
}

data class NotesItem(var id: Int, var title: String)

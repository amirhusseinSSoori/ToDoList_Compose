package com.amirhusseinsoori.todolist_780_compose.ui.screen.addTodo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.domain.entity.TodoModel
import com.amirhusseinsoori.todolist.ToDoViewModel

@Composable
fun AddToListScreen(
    viewModel: ToDoViewModel,
    context: Context = LocalContext.current
) {
    var title by remember { mutableStateOf("") }
    var des by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = { Text("title") }
        )
        Spacer(
            modifier = Modifier
                .height(40.dp)
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            value = des,
            onValueChange = {
                des = it
            },
            label = { Text("Description") }
        )
        Button(onClick = {
            if (title.isNullOrEmpty() && des.isNullOrEmpty()) {

                Toast.makeText(context, "Please input some things", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertTodoList(
                    TodoModel(
                        title = title,
                        description = des
                    )
                )
            }
        }) {
            Text(text = "Save")
        }


    }

}
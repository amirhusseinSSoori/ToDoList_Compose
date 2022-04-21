package com.amirhusseinsoori.addtodo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amirhusseinsoori.domain.entity.TodoModel


@Composable
fun AddToListScreen(
    navController: NavController,
    context: Context = LocalContext.current,
    viewModel: AddToDoViewModel = hiltViewModel(),

    ) {
    viewModel.apply {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            shape = RoundedCornerShape(50.dp),
            elevation = 40.dp
        ) {
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
                        .height(300.dp)
                        .padding(20.dp),
                    value = des,
                    onValueChange = {
                        des = it
                    },
                    label = { Text("Description") }
                )
                Button(onClick = {
                    if (title.isNullOrEmpty() && des.isNullOrEmpty()) {
                        Toast.makeText(context, "Please input some things", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        insertTodoList(
                            TodoModel(
                                title = title,
                                description = des
                            )
                        )
                        navController.popBackStack()

                    }
                }) {
                    Text(text = "Save")
                }
            }
        }
    }
}
package com.amirhusseinsoori.addtodo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amirhusseinsoori.common.Constance.title_description_not_empty
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
                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        if (it.length <= 30) title = it
                    },
                    singleLine = true,
                    label = { Text(stringResource(id = R.string.title)) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                        .padding(
                            start = 10.dp,
                            end = 10.dp
                        )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(20.dp),
                    value = des,
                    onValueChange = {
                        des = it
                    },
                    label = { Text(stringResource(id = R.string.description)) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )

                Button(onClick = {
                    if (title.isNullOrEmpty() || des.isNullOrEmpty()) {
                        Toast.makeText(context, title_description_not_empty, Toast.LENGTH_SHORT)
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
                    Text(text = stringResource(id = R.string.save))
                }
            }
        }
    }
}
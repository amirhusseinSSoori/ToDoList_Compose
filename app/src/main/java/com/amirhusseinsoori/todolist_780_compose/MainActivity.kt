package com.amirhusseinsoori.todolist_780_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amirhusseinsoori.todolist_780_compose.ui.theme.ToDoList_780_ComposeTheme

class MainActivity : ComponentActivity() {
    private val data: ArrayList<String> = arrayListOf("ali", "reza", "gholam")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoList_780_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(data)
                }
            }
        }
    }
}


@Composable
fun MainScreen(list: List<String> = emptyList()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(modifier = Modifier, onClick = { }) {
            Text(text = "Add To Do")
        }
        LazyColumn() {
            items(list) {
                TodoItemList(item = it)
            }

        }
    }
}

@Composable
fun TodoItemList(item: String) {
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
                text = "title : ".plus(item),
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

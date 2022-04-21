package com.amirhusseinsoori.todolist_780_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amirhusseinsoori.todolist.ToDoViewModel
import com.amirhusseinsoori.todolist_780_compose.main.navigation.InitialNavGraph
import com.amirhusseinsoori.todolist_780_compose.main.theme.ToDoList_780_ComposeTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(
        ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class,
        ExperimentalFoundationApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberAnimatedNavController()
            val viewModel: ToDoViewModel = hiltViewModel()
            ToDoList_780_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InitialNavGraph(navController, viewModel)
                    // TodoScreen(viewModel)
                }
            }
        }
    }
}







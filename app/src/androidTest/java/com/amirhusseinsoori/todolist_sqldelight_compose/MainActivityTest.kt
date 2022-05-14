package com.amirhusseinsoori.todolist_sqldelight_compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amirhusseinsoori.addtodo.AddToDoViewModel
import com.amirhusseinsoori.addtodo.AddToListScreen
import com.amirhusseinsoori.showtodo.ShowToDoScreen
import com.amirhusseinsoori.showtodo.ShowToDoViewModel
import com.amirhusseinsoori.todolist.ToDoViewModel
import com.amirhusseinsoori.todolist.TodoScreen
import com.amirhusseinsoori.todolist_sqldelight_compose.main.InitialNavGraph
import com.amirhusseinsoori.todolist_sqldelight_compose.main.theme.ToDoList_780_ComposeTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity


    @Before
    fun setup() {
        composeTestRule.activityRule.scenario.onActivity {
            activity = it
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Test
    fun activityTest() {
        composeTestRule.setContent {
            ToDoList_780_ComposeTheme {
                val navController: NavHostController = rememberAnimatedNavController()
                val viewModel: ToDoViewModel = hiltViewModel()
                InitialNavGraph(navController, viewModel)
            }
        }
    }


    @OptIn(ExperimentalAnimationApi::class)
    @Test
    fun toDoListTest() {
        composeTestRule.setContent {
            ToDoList_780_ComposeTheme {
                val navController: NavHostController = rememberAnimatedNavController()
                val viewModel: ToDoViewModel = hiltViewModel()
                TodoScreen(navController = navController, viewModel = viewModel)
            }
        }
    }


    @OptIn(ExperimentalAnimationApi::class)
    @Test
    fun showToDoTest() {
        composeTestRule.setContent {
            ToDoList_780_ComposeTheme {
                val viewModel: ShowToDoViewModel = hiltViewModel()
                ShowToDoScreen(showToDoViewModel = viewModel)
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Test
    fun addToDoTest() {
        composeTestRule.setContent {
            ToDoList_780_ComposeTheme {
                val viewModel: AddToDoViewModel = hiltViewModel()
                val navController: NavHostController = rememberAnimatedNavController()
                AddToListScreen(navController = navController, viewModel = viewModel)
            }
        }
    }
}
package com.amirhusseinsoori.todolist_780_compose.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.amirhusseinsoori.todolist.ToDoViewModel
import com.amirhusseinsoori.todolist.TodoScreen
import com.amirhusseinsoori.todolist_780_compose.ui.screen.addTodo.AddToListScreen
import com.amirhusseinsoori.todolist_780_compose.ui.screen.intro.Intro
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


@OptIn(
    ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun InitialNavGraph(navController: NavHostController, viewModel: ToDoViewModel) {
    AnimatedNavHost(navController = navController, startDestination = ScreenRoute.Intro.route) {
        addIntro(navController)
        addTodoList(navController, viewModel)
        addDetails(viewModel)

    }
}

//
@ExperimentalAnimationApi
fun NavGraphBuilder.addIntro(navController: NavController) {
    composable(
        ScreenRoute.Intro.route,
        enterTransition = {
            when (initialState.destination.route) {
                ScreenRoute.Todo.route ->
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                ScreenRoute.Todo.route ->
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        },
        popEnterTransition = {
            when (initialState.destination.route) {
                ScreenRoute.Todo.route ->
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        },
        popExitTransition = {
            when (targetState.destination.route) {
                ScreenRoute.Todo.route ->
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        }
    ) { Intro(navController) }

}

@ExperimentalAnimationApi
fun NavGraphBuilder.addTodoList(
    navController: NavController,
    viewModel: ToDoViewModel
) {
    composable(
        ScreenRoute.Todo.route,
        enterTransition = {
            when (initialState.destination.route) {
                ScreenRoute.AddDetails.route ->
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                ScreenRoute.AddDetails.route ->
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        },
        popEnterTransition = {
            when (initialState.destination.route) {
                ScreenRoute.AddDetails.route ->
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        },
        popExitTransition = {
            when (targetState.destination.route) {
                ScreenRoute.AddDetails.route ->
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                else -> null
            }
        }
    ) { TodoScreen(navController, viewModel) }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addDetails(viewModel: ToDoViewModel) {
    composable(
        ScreenRoute.AddDetails.route
    ) {
        AddToListScreen(viewModel)
    }
}

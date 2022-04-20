package com.amirhusseinsoori.todolist_780_compose.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.amirhusseinsoori.todolist_780_compose.ui.ToDoViewModel
import com.amirhusseinsoori.todolist_780_compose.ui.screen.intro.Intro
import com.amirhusseinsoori.todolist_780_compose.ui.screen.todo.TodoScreen
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
        composable(
            ScreenRoute.Todo.route
        ) { TodoScreen(viewModel) }
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
//
//@ExperimentalAnimationApi
//fun NavGraphBuilder.addTodoList(
//    viewModel: ToDoViewModel
//) {
//    composable(
//        route = ScreenRoute.Todo.route,
//        enterTransition = { _, _ ->
//            slideInHorizontally(
//                initialOffsetX = { -300 },
//                animationSpec = tween(
//                    durationMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//            ) + fadeIn(animationSpec = tween(300))
//        },
//        popExitTransition = { _, target ->
//            slideOutHorizontally(
//                targetOffsetX = { -300 },
//                animationSpec = tween(
//                    durationMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//            ) + fadeOut(animationSpec = tween(300))
//        }
//    ) {
//        TodoScreen(viewModel)
//    }
//}

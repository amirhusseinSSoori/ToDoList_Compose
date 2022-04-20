package com.amirhusseinsoori.todolist_780_compose.ui.navigation

sealed class ScreenRoute(val route: String) {
    object Intro : ScreenRoute("intro_screen")
    object Todo : ScreenRoute("todo_screen")
    object AddDetails : ScreenRoute("addDetails_screen")
}
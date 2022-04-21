package com.amirhusseinsoori.common

sealed class ScreenRoute(val route: String) {
    object Intro : ScreenRoute("intro_screen")
    object Todo : ScreenRoute("todo_screen")
    object AddDetails : ScreenRoute("addDetails_screen")
    object ShowToDo : ScreenRoute("ShowToDo_screen")
}
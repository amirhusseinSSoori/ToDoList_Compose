package com.amirhusseinsoori.todolist_780_compose.ui.screen

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.amirhusseinsoori.todolist_780_compose.R

val utilFont = FontFamily(
    Font(R.font.domine_bold, FontWeight.Light),
    Font(R.font.domine_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_regular, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.Bold)
)

fun Context.save(input: Int) {
    val save: SharedPreferences = this.getSharedPreferences("application", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = save.edit()
    editor.putInt("input", input)
    editor.apply()
}

fun Context.readLastButtonPressed(): Int {
    val sharedPref: SharedPreferences = this.getSharedPreferences("application", Context.MODE_PRIVATE)
    return sharedPref.getInt("LAST_BUTTON", 0)
}


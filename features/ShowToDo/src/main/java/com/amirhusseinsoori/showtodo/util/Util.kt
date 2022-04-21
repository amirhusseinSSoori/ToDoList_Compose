package com.amirhusseinsoori.showtodo.util

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


val red = Color(0xFFBD0B0B)
fun <T> SavedStateHandle.sendArgument(data: T): T {
    get<T>(data.toString()).let {
        return it!!
    }
}
@Module
@InstallIn(SingletonComponent::class)
object UtilModule {
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}
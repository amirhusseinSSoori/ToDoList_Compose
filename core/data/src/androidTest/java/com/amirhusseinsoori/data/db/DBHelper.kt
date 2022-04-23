package com.amirhusseinsoori.data.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider

object DBHelper {
    fun getInMemoryDb() = Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        MyDataBase::class.java
    ).allowMainThreadQueries()
        .build()
}

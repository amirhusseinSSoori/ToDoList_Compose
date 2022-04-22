package com.amirhusseinsoori.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.amirhusseinsoori.data.db.dao.ToDoDao
import com.amirhusseinsoori.data.db.model.ToDoEntity
import com.amirhusseinsoori.data.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [ToDoEntity::class],
    version = 1
)
abstract class MyDataBase : RoomDatabase() {
    abstract fun toDoListDao(): ToDoDao

    class Callback @Inject constructor(
        private val database: Provider<MyDataBase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = database.get().toDoListDao()
            applicationScope.launch(Dispatchers.IO) {
                dao.insert(
                    ToDoEntity(
                        title = "AmirHussein Soori",
                        description = "I am a Creative and driven Android Developer with 2+ years of\n" +
                                "experience fintec and Custom rom and building cutting edge\n" +
                                "Android apps for mobile devices. I am fluent in android\n" +
                                "architecture like mvvm , mvi and modular architecture.",
                        date = Calendar.getInstance().time.toString()
                    )
                )

            }
        }
    }
}
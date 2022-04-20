package com.amirhusseinsoori.data.di

import android.content.Context
import androidx.room.Room
import com.amirhusseinsoori.data.db.MyDataBase
import com.amirhusseinsoori.data.db.dao.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {



    @Singleton
    @Provides
    fun provideMyDb(
        @ApplicationContext context: Context
    ): MyDataBase {
        return Room
            .databaseBuilder(
                context,
                MyDataBase::class.java,
                "DbName"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideToDoListDAO(myDataBase: MyDataBase): ToDoDao {
        return myDataBase.toDoListDao()
    }
}
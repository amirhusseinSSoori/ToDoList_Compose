package com.amirhusseinsoori.data.di

import android.app.Application
import com.amirhusseinsoori.data.Database
import com.amirhusseinsoori.data.ToDoEntityQueries
import com.amirhusseinsoori.data.extention.createDatabaseDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application
    ): Database = app.applicationContext.createDatabaseDriver()
        .run {
            Database(this)
        }


    @Provides
    @Singleton
    fun provideTaskQueries(
        db: Database
    ): ToDoEntityQueries = db.toDoEntityQueries

//    @Singleton
//    @Provides
//    fun provideMyDb(
//        @ApplicationContext context: Context, callback: MyDataBase.Callback
//    ): MyDataBase {
//        return Room
//            .databaseBuilder(
//                context,
//                MyDataBase::class.java,
//                DbName
//            )
//            .fallbackToDestructiveMigration()
//            .addCallback(callback)
//            .build()
//    }

//    @Singleton
//    @Provides
//    fun provideToDoListDAO(myDataBase: MyDataBase): ToDoDao {
//        return myDataBase.toDoListDao()
//    }

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope
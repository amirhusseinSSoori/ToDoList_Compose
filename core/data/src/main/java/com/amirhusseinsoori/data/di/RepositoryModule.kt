package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.repository.DeleteToDoRepositoryImp
import com.amirhusseinsoori.data.repository.GetAllToDoListRepositoryImp
import com.amirhusseinsoori.data.repository.InsertToDoRepositoryImp
import com.amirhusseinsoori.domain.repository.DeleteToDoRepository
import com.amirhusseinsoori.domain.repository.GetAllToDoListRepository
import com.amirhusseinsoori.domain.repository.InsertToDoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule() {
    @Binds
    abstract fun bindGetAllToDoRepository(getAllToDoListRepositoryImp: GetAllToDoListRepositoryImp): GetAllToDoListRepository

    @Binds
    abstract fun bindDeleteToDoRepository(deleteToDoRepositoryImp: DeleteToDoRepositoryImp): DeleteToDoRepository

    @Binds
    abstract fun bindInsertToDoRepository(insertToDoRepositoryImp: InsertToDoRepositoryImp): InsertToDoRepository
}
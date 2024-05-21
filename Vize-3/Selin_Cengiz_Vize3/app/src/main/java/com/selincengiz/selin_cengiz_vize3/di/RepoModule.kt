package com.selincengiz.selin_cengiz_vize3.di

import com.selincengiz.selin_cengiz_vize3.data.repo.UsersRepoImpl
import com.selincengiz.selin_cengiz_vize3.data.source.remote.IUsersService
import com.selincengiz.selin_cengiz_vize3.domain.repo.IUsersRepo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideUsersRepo(usersService: IUsersService): IUsersRepo =
        UsersRepoImpl(usersService = usersService)

}
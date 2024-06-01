package com.selincengiz.selin_cengiz_odev10.di

import com.selincengiz.selin_cengiz_odev10.data.repo.NoteRepoImpl
import com.selincengiz.selin_cengiz_odev10.data.repo.UserRepoImpl
import com.selincengiz.selin_cengiz_odev10.data.source.local.INotesDao
import com.selincengiz.selin_cengiz_odev10.data.source.local.IUserDao
import com.selincengiz.selin_cengiz_odev10.domain.repo.INoteRepo
import com.selincengiz.selin_cengiz_odev10.domain.repo.IUserRepo

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
    fun provideNoteRepo(notesDao: INotesDao): INoteRepo =
        NoteRepoImpl(notesDao = notesDao)

    @Provides
    @Singleton
    fun provideUserRepo(userDao: IUserDao): IUserRepo =
        UserRepoImpl(userDao = userDao)
}
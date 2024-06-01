package com.toren.odev10.di

import android.content.Context
import com.toren.odev10.data.local.dao.NoteDao
import com.toren.odev10.data.local.dao.UserDao
import com.toren.odev10.data.local.db.DatabaseHelper
import com.toren.odev10.data.local.repo.NotesRepositoryImpl
import com.toren.odev10.data.local.repo.UserRepositoryImpl
import com.toren.odev10.domain.repo.NotesRepository
import com.toren.odev10.domain.repo.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabaseHelper(@ApplicationContext context: Context): DatabaseHelper {
        return DatabaseHelper(context)
    }

    @Singleton
    @Provides
    fun provideUserDao(@ApplicationContext context: Context) : UserDao {
        return UserDao(context)
    }

    @Singleton
    @Provides
    fun provideNotesDao(@ApplicationContext context: Context) : NoteDao {
        return NoteDao(context)
    }

    @Singleton
    @Provides
    fun provideUserRepo(userDao: UserDao) : UserRepository {
        return UserRepositoryImpl(userDao)
    }

    @Singleton
    @Provides
    fun provideNoteRepo(noteDao: NoteDao) : NotesRepository {
        return NotesRepositoryImpl(noteDao)
    }

}
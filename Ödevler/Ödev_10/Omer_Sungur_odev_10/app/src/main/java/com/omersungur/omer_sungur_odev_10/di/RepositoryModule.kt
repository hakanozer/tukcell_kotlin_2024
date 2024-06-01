package com.omersungur.omer_sungur_odev_10.di

import com.omersungur.omer_sungur_odev_10.data.local.database.note.NoteDao
import com.omersungur.omer_sungur_odev_10.data.local.database.user.UserDao
import com.omersungur.omer_sungur_odev_10.data.repository.note.NoteRepositoryImpl
import com.omersungur.omer_sungur_odev_10.data.repository.user.UserRepositoryImpl
import com.omersungur.omer_sungur_odev_10.domain.repository.note.NoteRepository
import com.omersungur.omer_sungur_odev_10.domain.repository.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userDao)
    }
}
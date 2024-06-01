package com.yeceylan.yunusemreceylan_odev10.di

import android.content.Context
import androidx.room.Room
import com.yeceylan.yunusemreceylan_odev10.model.dao.NoteDao
import com.yeceylan.yunusemreceylan_odev10.model.dao.UserDao
import com.yeceylan.yunusemreceylan_odev10.model.database.AppDatabase
import com.yeceylan.yunusemreceylan_odev10.model.repository.NoteRepository
import com.yeceylan.yunusemreceylan_odev10.model.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "notes_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepository(noteDao)
    }
}

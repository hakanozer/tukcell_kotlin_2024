package com.selincengiz.selin_cengiz_odev10.di

import android.content.Context
import androidx.room.Room
import com.selincengiz.selin_cengiz_odev10.data.source.local.NoteRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDBModule {

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteRoomDB::class.java, "notes_db")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideNoteDao(roomDB: NoteRoomDB) = roomDB.noteDao()

    @Provides
    @Singleton
    fun provideUserDao(roomDB: NoteRoomDB) = roomDB.userDao()
}
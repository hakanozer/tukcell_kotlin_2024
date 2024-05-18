package com.selincengiz.selin_cengiz_odev8.di

import android.content.Context
import androidx.room.Room
import com.selincengiz.selin_cengiz_odev8.data.source.local.RecipeRoomDB
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
        Room.databaseBuilder(context, RecipeRoomDB::class.java, "recipes_db").build()

    @Provides
    @Singleton
    fun provideRoomDao(roomDB: RecipeRoomDB) = roomDB.recipeDao()
}
package com.omersungur.omer_sungur_odev_10.di

import android.content.Context
import androidx.room.Room
import com.omersungur.omer_sungur_odev_10.core.Constants.TO_DO_DATABASE
import com.omersungur.omer_sungur_odev_10.data.local.database.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ToDoDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = ToDoDatabase::class.java,
            name = TO_DO_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun provideFirstDao(database: ToDoDatabase) = database.noteDao()

    @Singleton
    @Provides
    fun provideSecondDao(database: ToDoDatabase) = database.userDao()
}
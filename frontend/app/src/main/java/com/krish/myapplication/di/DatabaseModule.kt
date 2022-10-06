package com.krish.myapplication.di

import android.content.Context
import androidx.room.Room
import com.krish.myapplication.data.local.NoteDatabase
import com.krish.myapplication.data.repository.LocalDataSourceImpl
import com.krish.myapplication.domain.LocalDataSource
import com.krish.myapplication.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideLocalDataSource(
        noteDatabase: NoteDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            noteDatabase = noteDatabase
        )
    }
}
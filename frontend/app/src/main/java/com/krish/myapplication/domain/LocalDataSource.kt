package com.krish.myapplication.domain

import com.krish.myapplication.data.model.Note
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    fun getAllNotes(): Flow<List<Note>>
}
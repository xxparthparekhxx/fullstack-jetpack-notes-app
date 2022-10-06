package com.krish.myapplication.data.repository

import com.krish.myapplication.data.local.NoteDatabase
import com.krish.myapplication.data.model.Note
import com.krish.myapplication.domain.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    noteDatabase: NoteDatabase
) : LocalDataSource {
    private val noteDao = noteDatabase.noteDao()

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }
}
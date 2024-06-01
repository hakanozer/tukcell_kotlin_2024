package com.yeceylan.yunusemreceylan_odev10.model.repository

import com.yeceylan.yunusemreceylan_odev10.model.dao.NoteDao
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note
import javax.inject.Inject

class NoteRepository(private val noteDao: NoteDao) {
    suspend fun insert(note: Note) = noteDao.insert(note)
    suspend fun update(note: Note) = noteDao.update(note)
    suspend fun delete(note: Note) = noteDao.delete(note)
    suspend fun getNotesForUser(username: String) = noteDao.getNotesForUser(username)
    suspend fun searchNotes(username: String, query: String) = noteDao.searchNotes(username, query)
}
package com.selincengiz.selin_cengiz_odev10.domain.repo

import com.selincengiz.selin_cengiz_odev10.common.Resource
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI

interface INoteRepo {
    suspend fun getNotesByQuery(search: String): Resource<List<NotesUI>>

    suspend fun getAllNote(): Resource<List<NotesUI>>

    suspend fun addNote(note: NotesUI)

    suspend fun deleteNote(note: NotesUI)
}
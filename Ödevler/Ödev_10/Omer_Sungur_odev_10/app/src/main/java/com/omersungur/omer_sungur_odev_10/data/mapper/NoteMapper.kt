package com.omersungur.omer_sungur_odev_10.data.mapper

import com.omersungur.omer_sungur_odev_10.data.local.database.note.entity.NoteEntity
import com.omersungur.omer_sungur_odev_10.domain.model.Note

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        description = description
    )
}

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        description = description
    )
}
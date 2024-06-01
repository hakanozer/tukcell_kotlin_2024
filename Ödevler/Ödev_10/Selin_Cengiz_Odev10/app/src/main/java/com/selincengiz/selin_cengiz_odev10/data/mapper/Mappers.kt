package com.selincengiz.selin_cengiz_odev10.data.mapper

import com.selincengiz.selin_cengiz_odev10.data.entities.NotesRoom
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI


fun NotesRoom.mapToNotesUI(): NotesUI {
    return NotesUI(
        id,
        title,
        body,
    )
}

fun NotesUI.mapToNoteRoom(): NotesRoom {
    return NotesRoom(
        id = id ?: 0,
        title = title,
        body = body,
    )
}
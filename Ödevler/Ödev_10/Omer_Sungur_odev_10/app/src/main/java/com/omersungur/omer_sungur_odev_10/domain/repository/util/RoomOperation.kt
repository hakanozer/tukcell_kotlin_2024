package com.omersungur.omer_sungur_odev_10.domain.repository.util

import com.omersungur.omer_sungur_odev_10.domain.model.Note

fun interface RoomOperation {

    fun deleteNote(note: Note)
}
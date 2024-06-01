package com.selincengiz.selin_cengiz_odev10.common


import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI


sealed interface HomeState {
    data object Entry : HomeState
    data class Notes(val list: List<NotesUI>?) : HomeState
    data class Error(val throwable: Throwable) : HomeState
}
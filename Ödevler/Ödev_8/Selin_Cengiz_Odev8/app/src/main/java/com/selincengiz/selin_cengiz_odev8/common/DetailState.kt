package com.selincengiz.selin_cengiz_odev8.common

sealed interface DetailState {
    object Entry : DetailState
    data class IsFavorite(val state: Boolean) : DetailState
    data class Error(val throwable: Throwable) : DetailState
}
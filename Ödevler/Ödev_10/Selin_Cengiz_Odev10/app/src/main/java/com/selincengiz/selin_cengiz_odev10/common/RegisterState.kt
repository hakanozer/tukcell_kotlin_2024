package com.selincengiz.selin_cengiz_odev10.common

sealed interface RegisterState {
    data object Entry : RegisterState
    data class Registered(val message: String?) : RegisterState
    data class Error(val throwable: Throwable) : RegisterState
}
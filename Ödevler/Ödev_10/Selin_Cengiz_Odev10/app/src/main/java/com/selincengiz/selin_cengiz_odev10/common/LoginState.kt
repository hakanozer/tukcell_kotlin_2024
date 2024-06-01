package com.selincengiz.selin_cengiz_odev10.common


sealed interface LoginState {
    data object Entry : LoginState
    data class Logined(val message: String?) : LoginState
    data class Error(val throwable: Throwable) : LoginState
}
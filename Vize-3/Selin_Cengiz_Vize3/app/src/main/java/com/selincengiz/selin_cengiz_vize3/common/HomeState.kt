package com.selincengiz.selin_cengiz_vize3.common

import com.selincengiz.selin_cengiz_vize3.domain.entities.UserUI


sealed interface HomeState {
    object Entry : HomeState
    object Loading : HomeState
    data class Users(val list: List<UserUI>?) : HomeState
    data class Error(val throwable: Throwable) : HomeState
}
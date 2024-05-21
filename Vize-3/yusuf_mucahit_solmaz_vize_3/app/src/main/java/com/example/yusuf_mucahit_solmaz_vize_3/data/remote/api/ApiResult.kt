package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.api

sealed class ApiResult <out T> {
    data class Success<out R>(val data: R?) : ApiResult<R>()
    data class Error(val message:String) : ApiResult<Nothing>()
    data object Loading : ApiResult<Nothing>()
}
package com.muratdayan.odev9.core.common

sealed class Resource<T>(val data: T? = null, val msg: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(msg: String) : Resource<T>(msg = msg)
    class Loading<T> : Resource<T>()
}
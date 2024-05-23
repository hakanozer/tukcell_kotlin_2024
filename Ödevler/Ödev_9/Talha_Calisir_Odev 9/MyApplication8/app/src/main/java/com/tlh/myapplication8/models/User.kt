package com.tlh.myapplication8.models
import java.io.Serializable

data class User (
    val users: List<Users>,
    val total: Long,
    val skip: Long,
    val limit: Long
):Serializable


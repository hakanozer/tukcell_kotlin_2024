package com.example.emre_bitik_odev_10.models

import java.io.Serializable


data class Note (
    val cid:Int,
    val title: String,
    val details: String

): Serializable
data class User (
    val cid: Int,
    val username: String,
    val password: String
    )
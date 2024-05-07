package com.umutyusufcinar.vize2app.service

import java.io.Serializable

data class Common(
    val commonName: String,
    val botanical: String,
    val zone: String,
    val light: String,
    val price: String
) : Serializable

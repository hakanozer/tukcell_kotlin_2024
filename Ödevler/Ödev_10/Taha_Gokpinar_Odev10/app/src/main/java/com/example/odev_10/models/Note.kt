package com.example.odev_10.models

import java.io.Serializable

data class Note(
    val nid: Int,
    val uid: Int,
    val title: String,
    val content: String
):Serializable

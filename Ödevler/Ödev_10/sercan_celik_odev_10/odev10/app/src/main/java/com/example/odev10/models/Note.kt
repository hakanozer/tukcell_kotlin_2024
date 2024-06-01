package com.example.odev10.models

import java.io.Serializable

data class Note(
    val nid: Int,
    val title: String,
    val content: String
) : Serializable

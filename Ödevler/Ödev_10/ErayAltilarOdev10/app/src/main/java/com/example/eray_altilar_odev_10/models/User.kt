package com.example.eray_altilar_odev_10.models

data class User(
    val cid: Int,
    val userName: String,
    val password: String,
    val notes: List<Note>
)

data class Note (
    val nid: Int,
    val cid: Int,
    var noteTitle: String,
)
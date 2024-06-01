package com.muratdayan.odev10.models

import java.io.Serializable

data class Note(
    val nid:Int,
    val title:String,
    val detail:String,
    val priority:Int,
    val date:String?,
    val isDone:Int
) : Serializable

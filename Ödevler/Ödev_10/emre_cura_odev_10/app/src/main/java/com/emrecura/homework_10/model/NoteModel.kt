package com.emrecura.homework_10.model

import java.io.Serializable

data class NoteModel (
    val id:Int,
    val userId : Int,
    val title:String,
    val detail:String,
    val date:String
) : Serializable

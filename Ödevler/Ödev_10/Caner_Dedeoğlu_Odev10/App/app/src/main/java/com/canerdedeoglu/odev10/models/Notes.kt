package com.canerdedeoglu.odev10.models

data class Notes(
    val noteId : Int,
    val title : String,
    val description : String,
    val date : String,
    val category : String,
    val userId : Int
)


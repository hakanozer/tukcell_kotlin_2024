package com.muratdayan.vize2.models

import java.io.Serializable

data class PlantModel(
    val common:String,
    val botanical:String,
    val zone:String,
    val light:String,
    val price:String,
    val availability:String
): Serializable

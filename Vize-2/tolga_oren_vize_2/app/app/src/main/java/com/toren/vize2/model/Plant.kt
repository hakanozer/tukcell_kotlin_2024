package com.toren.vize2.model

import java.io.Serializable

data class Plant(
    var common : String,
    var botanical : String,
    var zone : String,
    var light : String,
    var price : String,
    var availability : Int
) : Serializable

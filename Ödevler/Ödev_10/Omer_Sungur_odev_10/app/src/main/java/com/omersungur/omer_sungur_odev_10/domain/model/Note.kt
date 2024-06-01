package com.omersungur.omer_sungur_odev_10.domain.model

import java.io.Serializable

data class Note(
    val id: Int,
    val title: String,
    val description: String,
): Serializable
package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity

import java.io.Serializable

data class RootResponse(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserX>
): Serializable
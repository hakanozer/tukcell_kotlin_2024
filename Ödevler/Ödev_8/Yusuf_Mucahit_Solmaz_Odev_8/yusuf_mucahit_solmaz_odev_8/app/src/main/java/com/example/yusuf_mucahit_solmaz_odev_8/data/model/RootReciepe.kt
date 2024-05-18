package com.example.yusuf_mucahit_solmaz_odev_8.data.model

data class RootReciepe(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)
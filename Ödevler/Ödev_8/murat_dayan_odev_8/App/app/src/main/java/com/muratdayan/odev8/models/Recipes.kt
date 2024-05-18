package com.muratdayan.odev8.models

import java.io.Serializable

data class Recipes(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
):Serializable
package com.works.days_4.models

import java.io.Serializable

data class User(val id: Int, val userName: String, val password: String) : Serializable

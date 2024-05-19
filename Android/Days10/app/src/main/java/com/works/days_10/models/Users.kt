package com.works.days_10.models

data class Users (
    val posts: List<Post>,
    val total: Long,
    val skip: Long,
    val limit: Long
)

data class Post (
    val id: Long,
    val title: String,
    val body: String,
    val userId: Long,
    val tags: List<String>,
    val reactions: Long
)

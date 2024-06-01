package com.aliberkaygedikoglu.odev10.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class UserNote(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int?,
    val name:String,
    val detail:String
):Serializable
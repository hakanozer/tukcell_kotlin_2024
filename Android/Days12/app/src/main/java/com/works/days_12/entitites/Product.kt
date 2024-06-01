package com.works.days_12.entitites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pid")
    val pid: Int?,

    val title: String,
    val detail: String,
    //@ColumnInfo(typeAffinity = ColumnInfo.REAL)
    val price: Float

)

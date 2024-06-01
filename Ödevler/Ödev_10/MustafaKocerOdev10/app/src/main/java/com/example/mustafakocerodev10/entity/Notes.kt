package com.example.mustafakocerodev10.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "notes", foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["foreignUID"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
// ikinci bir foreign key eklemek isterden yukarıdakini double'la ve aynı işlemleri yap
    ]
)
data class Notes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nid")
    val nid: Int?,
    val foreignUID: Int,
    val title: String,
    val description: String?,
    val creationDate: String
)  : Serializable

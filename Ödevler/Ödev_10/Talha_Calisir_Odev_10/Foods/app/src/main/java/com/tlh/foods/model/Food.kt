package com.tlh.foods.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Food(
    @ColumnInfo(name = "name")
    @SerializedName("isim")
    val foodName: String?,
    @ColumnInfo(name = "calorie")
    @SerializedName("kalori")
    val foodCalorie: String?,
    @ColumnInfo(name = "carbohydrates")
    @SerializedName("karbonhidrat")
    val foodCarbohHydrate : String?,
    @ColumnInfo(name = "protein")
    @SerializedName("protein")
    val foodProtein: String?,
    @ColumnInfo(name = "oil")
    @SerializedName("yag")
    val foodOil : String?,
    @ColumnInfo(name = "image")
    @SerializedName("gorsel")
    val foodImage: String?
) {

    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0

}
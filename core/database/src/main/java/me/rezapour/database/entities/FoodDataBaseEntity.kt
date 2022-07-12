package me.rezapour.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "food_table")
data class FoodDataBaseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "meal_type") val mealType: String,
    @ColumnInfo(name = "is_vegetarian") val isVegetarian: Boolean,
    @ColumnInfo(name = "recipe") val recipe: String,
    @ColumnInfo(name = "created_data") val createdDate: Calendar
)
package me.rezapour.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import me.rezapour.database.entities.FoodDataBaseEntity

@Dao
interface FoodDao {

    @Insert(onConflict = REPLACE)
    suspend fun insetFood(foodDataBaseEntity: FoodDataBaseEntity): Long

    @Query("Select * from food_table where name= :foodName")
    suspend fun searchFoodByName(foodName: String): FoodDataBaseEntity
}
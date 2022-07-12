package me.rezapour.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import me.rezapour.database.dao.FoodDao
import me.rezapour.database.entities.FoodDataBaseEntity
import me.rezapour.database.utiles.Converters


@Database(entities = [FoodDataBaseEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}
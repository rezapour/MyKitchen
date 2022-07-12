package me.rezapour.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.rezapour.database.AppDataBase
import me.rezapour.database.dao.FoodDao
import me.rezapour.database.utiles.Constants
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideFoodDatabase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, Constants.DATA_BASE_NAME).build()


    @Provides
    @Singleton
    fun provideFoodDao(database: AppDataBase): FoodDao =
        database.foodDao()

}
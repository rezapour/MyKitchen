package me.rezapour.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import me.rezapour.database.dao.FoodDao
import me.rezapour.database.entities.FoodDataBaseEntity
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*
import kotlin.jvm.Throws


@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var foodDao: FoodDao
    private lateinit var foodDataBase: AppDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        foodDataBase = Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java).build()
        foodDao = foodDataBase.foodDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        foodDataBase.close()
    }

    @Test
    @Throws(Exception::class)
    fun testFoodDatabase() =runBlocking {


        val food = FoodDataBaseEntity(
            id = 1, name = "polo", mealType = "lunch", isVegetarian = true, recipe = "bahbah",
            Calendar.getInstance()
        )
        foodDao.insetFood(food)

        val result = foodDao.searchFoodByName(food.name)
        assertThat(result, equalTo(food))
    }


}




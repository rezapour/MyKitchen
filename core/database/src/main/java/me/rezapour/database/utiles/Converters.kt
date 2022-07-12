package me.rezapour.database.utiles

import androidx.room.TypeConverter
import java.util.*


class Converters {

    @TypeConverter
    fun calendarToDateStamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun dateStampToCalendar(dateStamp: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = dateStamp }

}
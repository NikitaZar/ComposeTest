package ru.mobile.data.db.converters

import androidx.room.TypeConverter
import java.util.Date

internal class DateConverter {

    @TypeConverter
    fun toDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}

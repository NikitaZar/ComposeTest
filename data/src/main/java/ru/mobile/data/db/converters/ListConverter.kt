package ru.mobile.data.db.converters

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class ListConverter {
    @TypeConverter
    fun toList(data: String): List<String> {
        return Json.decodeFromString(data)
    }

    @TypeConverter
    fun fromList(list: List<String?>): String {
        return Json.encodeToString(list)
    }
}
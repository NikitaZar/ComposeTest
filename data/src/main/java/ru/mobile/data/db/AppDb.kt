package ru.mobile.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.mobile.data.db.converters.DateConverter
import ru.mobile.data.db.converters.ListConverter

@Database(entities = [ProductItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class, DateConverter::class)
abstract class AppDb : RoomDatabase() {

    abstract fun productDao(): ProductDao
}

package ru.mobile.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "item")
data class ProductItemEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("time")
    val time: Date,
    @ColumnInfo("tags")
    val tags: List<String>,
    @ColumnInfo("amount")
    val amount: Int,
)

package ru.mobile.data.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM item WHERE name LIKE '%' || :filterName  || '%'")
    fun getFilteredProducts(filterName: String): List<ProductItemEntity>

    @Query("UPDATE item SET amount=:newAmount WHERE id =:id")
    suspend fun updateAmountById(id: Int, newAmount: Int)

    @Query("SELECT amount FROM item WHERE id==:id")
    suspend fun getAmountByItemId(id: Int): Int

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun deleteProductById(id: Int)
}
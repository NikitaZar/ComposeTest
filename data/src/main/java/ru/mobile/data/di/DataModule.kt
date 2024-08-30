package ru.mobile.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.mobile.data.ProductRepositoryImpl
import ru.mobile.data.db.AppDb
import ru.mobile.data.db.ProductDao
import ru.mobile.data.mappers.ProductItemMapper
import ru.mobile.data.mappers.ProductItemMapperImpl
import ru.mobile.domain.ProductRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, PRODUCT_DB)
            .createFromAsset(PRODUCT_DB)
            .build()
    }

    @Provides
    @Singleton
    fun provideNumberDao(
        appDb: AppDb
    ): ProductDao = appDb.productDao()

    companion object {
        private const val PRODUCT_DB = "data.db"
    }

    @Provides
    @Singleton
    fun provideProductRepository(dao: ProductDao, mapper: ProductItemMapper): ProductRepository {
        return ProductRepositoryImpl(dao, mapper)
    }

    @Provides
    fun provideProductMapper(): ProductItemMapper {
        return ProductItemMapperImpl()
    }
}

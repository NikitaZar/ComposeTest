package ru.mobile.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mobile.domain.FilterProductUseCase
import ru.mobile.domain.ProductRepository
import ru.mobile.domain.impl.FilterProductUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideFilterProductUseCase(productRepository: ProductRepository): FilterProductUseCase {
        return FilterProductUseCaseImpl(productRepository)
    }
}

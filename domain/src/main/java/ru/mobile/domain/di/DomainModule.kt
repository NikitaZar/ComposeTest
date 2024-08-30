package ru.mobile.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mobile.domain.ProductRepository
import ru.mobile.domain.impl.DeleteItemUseCaseImpl
import ru.mobile.domain.impl.EditAmountUseCaseImpl
import ru.mobile.domain.impl.FilterProductUseCaseImpl
import ru.mobile.domain.useCase.DeleteItemUseCase
import ru.mobile.domain.useCase.EditAmountUseCase
import ru.mobile.domain.useCase.FilterProductUseCase

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideFilterProductUseCase(productRepository: ProductRepository): FilterProductUseCase {
        return FilterProductUseCaseImpl(productRepository)
    }

    @Provides
    fun provideEditAmountUseCase(productRepository: ProductRepository): EditAmountUseCase {
        return EditAmountUseCaseImpl(productRepository)
    }

    @Provides
    fun provideDeleteItemUseCase(productRepository: ProductRepository): DeleteItemUseCase {
        return DeleteItemUseCaseImpl(productRepository)
    }
}

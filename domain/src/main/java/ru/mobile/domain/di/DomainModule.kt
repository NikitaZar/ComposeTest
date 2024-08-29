package ru.mobile.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mobile.domain.FilterProductUseCase
import ru.mobile.domain.ProductStateFlowUseCase
import ru.mobile.domain.impl.FilterProductUseCaseImpl
import ru.mobile.domain.impl.ProductStateFlowUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideFilterProductUseCase(): FilterProductUseCase {
        return FilterProductUseCaseImpl()
    }

    @Provides
    fun provideProductStateFlowUseCase(): ProductStateFlowUseCase {
        return ProductStateFlowUseCaseImpl()
    }
}

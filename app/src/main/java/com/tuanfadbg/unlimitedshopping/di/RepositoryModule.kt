package com.tuanfadbg.unlimitedshopping.di

import com.tuanfadbg.unlimitedshopping.data.repository.ProductRepositoryImpl
import com.tuanfadbg.unlimitedshopping.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
} 
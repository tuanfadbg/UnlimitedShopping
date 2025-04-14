package com.tuanfadbg.unlimitedshopping.domain.repository

import com.tuanfadbg.unlimitedshopping.data.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id: Int): Product
} 
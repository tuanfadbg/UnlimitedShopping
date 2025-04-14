package com.tuanfadbg.unlimitedshopping.data.repository

import com.tuanfadbg.unlimitedshopping.data.api.ProductApi
import com.tuanfadbg.unlimitedshopping.data.model.Product
import com.tuanfadbg.unlimitedshopping.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return api.getProducts()
    }

    override suspend fun getProduct(id: Int): Product {
        return api.getProduct(id)
    }
} 
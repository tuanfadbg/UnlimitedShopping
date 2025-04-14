package com.tuanfadbg.unlimitedshopping.data.api

import com.tuanfadbg.unlimitedshopping.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product
} 
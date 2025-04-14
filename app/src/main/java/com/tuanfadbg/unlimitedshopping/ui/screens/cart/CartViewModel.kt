package com.tuanfadbg.unlimitedshopping.ui.screens.cart

import androidx.lifecycle.ViewModel
import com.tuanfadbg.unlimitedshopping.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {

    private val _cartItems = MutableStateFlow<List<Product>>(emptyList())
    val cartItems: StateFlow<List<Product>> = _cartItems.asStateFlow()

    fun addToCart(product: Product) {
        _cartItems.value = _cartItems.value + product
    }

    fun removeFromCart(product: Product) {
        _cartItems.value = _cartItems.value.filter { it.id != product.id }
    }

    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.price }
    }
} 
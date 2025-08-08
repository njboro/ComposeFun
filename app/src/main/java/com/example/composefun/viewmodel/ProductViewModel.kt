package com.example.composefun.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefun.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    val products : StateFlow<List<Product>> = _products

    init {
        setDummyProductList()
    }

    private fun setDummyProductList() {
        viewModelScope.launch {
            _products.value = listOf(
                Product(
                    id = 1,
                    name = "Watch",
                    imageProduct = "url",
                    imageProduct2 = "url2",
                    imageProduct3 = "url3"
                ),
                Product(
                    id = 2,
                    name = "Samsung - Smartphone",
                    imageProduct = "url",
                    imageProduct2 = "url2",
                    imageProduct3 = "url3"
                ),
                Product(
                    id = 3,
                    name = "Refrigerator",
                    imageProduct = "url",
                    imageProduct2 = "url2",
                    imageProduct3 = "url3"
                ),
                Product(
                    id = 1,
                    name = "Washing Machine",
                    imageProduct = "url",
                    imageProduct2 = "url2",
                    imageProduct3 = "url3"
                )
            )
        }
    }
}
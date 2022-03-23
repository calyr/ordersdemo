package com.devback.demo.product.application.`in`

import com.devback.demo.product.domain.Product

interface IProductService {
    fun addProduct(product: Product): Product
    fun deleteProduct(product: Product)
    fun getList() : ArrayList<Product>
}
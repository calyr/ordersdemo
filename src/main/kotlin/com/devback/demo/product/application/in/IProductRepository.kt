package com.devback.demo.product.application.`in`

import com.devback.demo.product.domain.Product

interface IProductRepository {
    fun getList(): ArrayList<Product>
    fun addProduct(product: Product) : Product
    fun deleteProduct( product: Product)
}
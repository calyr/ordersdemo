package com.devback.demo.product.application.`in`

import com.devback.demo.product.domain.Product
import java.util.*
import kotlin.collections.ArrayList

interface IProductRepository {
    fun getList(): ArrayList<Product>
    fun addProduct(product: Product) : Product
    fun updateProduct(product: Product) : Product?
    fun deleteProduct( id: UUID) : Product?
}
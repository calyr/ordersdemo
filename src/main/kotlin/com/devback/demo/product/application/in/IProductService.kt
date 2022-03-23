package com.devback.demo.product.application.`in`

import com.devback.demo.product.domain.Product
import java.util.*
import kotlin.collections.ArrayList

interface IProductService {
    fun addProduct(product: Product): Product
    fun deleteProduct(productId: UUID) : Product?
    fun getList() : ArrayList<Product>
    fun updateProduct(product: Product): Product?
}
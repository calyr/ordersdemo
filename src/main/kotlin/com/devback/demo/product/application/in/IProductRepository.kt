package com.devback.demo.product.application.`in`

import com.devback.demo.product.domain.Product
import com.devback.demo.product.domain.ProductName
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList

interface IProductRepository {
    fun getList(): ArrayList<Product>
    fun addProduct(product: Product) : Any
    fun updateProduct(id: UUID, name: ProductName, price: BigDecimal) : Any?
    fun deleteProduct( id: UUID) : Any?
    fun findByName(name: String) : Any
}
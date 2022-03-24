package com.devback.demo.order.application.port.`in`

import com.devback.demo.order.domain.Order
import com.devback.demo.product.domain.Product
import java.util.*
import kotlin.collections.ArrayList

interface IOrderRepository {
    fun add(order: Order) : Any
    fun getItems(): Any
    fun addProduct(id: UUID, product: Product): Any
    fun getProducts(id: UUID): ArrayList<Product>
    fun getOrder(id: UUID): Any
    fun deleteOrder(id: UUID) : Any
}
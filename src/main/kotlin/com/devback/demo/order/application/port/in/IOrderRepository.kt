package com.devback.demo.order.application.port.`in`

import com.devback.demo.order.domain.Order
import com.devback.demo.product.domain.Product
import java.util.*
import kotlin.collections.ArrayList

interface IOrderRepository {
    fun findById(id: UUID) : Optional<Order>
    fun add(order: Order) : Order
    fun getItems(): ArrayList<Order>
    fun addProduct(id: UUID, product: Product): Order?
    fun getProducts(id: UUID): ArrayList<Product>
    fun getOrder(id: UUID): Order?
}
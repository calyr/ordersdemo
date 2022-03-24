package com.devback.demo.order.application.port.`in`

import com.devback.demo.order.domain.Order
import com.devback.demo.product.domain.Product
import java.util.*
import kotlin.collections.ArrayList

interface IOrdersUseCase {
    fun getOrders(): ArrayList<Order>
    fun create(order: Order) : Order
    fun addProduct(id: UUID, productId: UUID): Order?
    fun getOrder(id: UUID): Order?
    fun getProducts(id: UUID): ArrayList<Product>
}
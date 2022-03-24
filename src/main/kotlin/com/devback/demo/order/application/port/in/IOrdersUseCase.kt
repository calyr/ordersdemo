package com.devback.demo.order.application.port.`in`

import com.devback.demo.order.domain.Order
import com.devback.demo.product.domain.Product
import java.util.*
import kotlin.collections.ArrayList

interface IOrdersUseCase {
    fun getOrders(): Any
    fun create(order: Order) : Order
    fun addProduct(id: UUID, productId: UUID): Any?
    fun getOrder(id: UUID): Any
    fun getProducts(id: UUID): ArrayList<Product>
    fun deleteOrder(id: UUID): Any
    fun findByName(name: String) : Any
    fun findByDescription(description: String) : Any

}
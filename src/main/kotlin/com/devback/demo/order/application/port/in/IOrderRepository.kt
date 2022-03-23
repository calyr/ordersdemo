package com.devback.demo.order.application.port.`in`

import com.devback.demo.order.domain.Order
import java.util.*
import kotlin.collections.ArrayList

interface IOrderRepository {
    fun findById(id: UUID) : Optional<Order>
    fun save(order: Order)
    fun getItems(): ArrayList<Order>
}
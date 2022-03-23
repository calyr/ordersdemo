package com.devback.demo.order.application.port.`in`

import com.devback.demo.order.domain.Order

interface IOrdersUseCase {
    fun getOrders(): ArrayList<Order>
    fun save(order: Order)
}
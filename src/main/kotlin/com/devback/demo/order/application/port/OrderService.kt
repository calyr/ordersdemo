package com.devback.demo.order.application.port

import com.devback.demo.order.application.port.`in`.IOrdersUseCase
import com.devback.demo.order.application.port.`in`.IOrderRepository
import com.devback.demo.order.domain.Order
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: IOrderRepository): IOrdersUseCase {
    override fun getOrders() = orderRepository.getItems()
    override fun save(order: Order) {
        orderRepository.save(order)
    }


}
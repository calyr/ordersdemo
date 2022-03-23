package com.devback.demo.order.adapter.`in`.api

import com.devback.demo.order.application.port.`in`.IOrderRepository
import com.devback.demo.order.domain.Order
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
class OrderRepository: IOrderRepository {

    private val orderMap = ArrayList<Order>()

    override fun findById(id: UUID): Optional<Order> {
        TODO("Not yet implemented")
    }

    override fun save(order: Order) {
       orderMap.add(order)
    }

    override fun getItems() = orderMap
}
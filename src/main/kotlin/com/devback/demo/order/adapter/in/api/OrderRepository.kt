package com.devback.demo.order.adapter.`in`.api

import com.devback.demo.order.application.port.`in`.IOrderRepository
import com.devback.demo.order.domain.Order
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
class OrderRepository: IOrderRepository {

    private val data = ArrayList<Order>()

    override fun findById(id: UUID): Optional<Order> {
        TODO("Not yet implemented")
    }

    override fun add(order: Order): Order {
        data.add(order)
        return order
    }

    override fun getItems() = data
    override fun addProduct(id: UUID, product: Product) : Order? {
        val order = data.find { it.id == id }
        order?.addProduct(product)
        return order
    }

    override fun getProducts(id: UUID): ArrayList<Product> {
        val order = data.find { it.id == id }
        return order?.items ?: arrayListOf()
    }

    override fun getOrder(id: UUID): Order? {
        val order = data.find { it.id == id }
        return order
    }
}
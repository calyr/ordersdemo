package com.devback.demo.order.adapter.`in`.api

import com.devback.demo.order.application.port.`in`.IOrderRepository
import com.devback.demo.order.application.port.out.error.ApiResponse
import com.devback.demo.order.application.port.out.error.NotFoundException
import com.devback.demo.order.domain.Order
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
class OrderRepository: IOrderRepository {

    private val data = ArrayList<Order>()

    override fun add(order: Order): Any {
        data.add(order)
        return ApiResponse(0, "The Order was created", result = order)
    }

    override fun getItems(): Any {
        return ApiResponse(0, "Total orders (${data.size})", result = data)
    }
    override fun addProduct(id: UUID, product: Product): Any {
        val order = data.find { it.id == id }
        return if(order != null) {
            order.addProduct(product)
            return ApiResponse(0, "The product added", result = order)
        } else {
            throw NotFoundException("The orderId doesn't belong in the order list.")
        }

    }

    override fun getProducts(id: UUID): ArrayList<Product> {
        val order = data.find { it.id == id }
        return order?.items ?: arrayListOf()
    }

    override fun getOrder(id: UUID): Any {
        val order = data.find { it.id == id }

        if(order != null) {
            return ApiResponse(0, "Successful", result = order)
        } else {
            throw NotFoundException("The orderId doesn't belong in the order list.")
        }
    }

    override fun deleteOrder(id: UUID): Any {
        val order = data.find { it.id == id }
        return if(order != null) {
            data.remove(order)
            ApiResponse(0, "The order was deleted", result = order)
        } else {
            throw NotFoundException("The orderId doesn't belong in the Order list.")
        }
    }

    override fun findByName(name: String): Any {
        val order = data.filter { it.name.value.contains(name) }
        return ApiResponse(0, "Count result ${order.size}", result = order)
    }

    override fun findByDescription(name: String): Any {
        val order = data.filter { it.description.value.contains(name) }
        return ApiResponse(0, "Count result ${order.size}", result = order)
    }
}
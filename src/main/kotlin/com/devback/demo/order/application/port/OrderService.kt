package com.devback.demo.order.application.port

import com.devback.demo.order.application.port.`in`.IOrdersUseCase
import com.devback.demo.order.application.port.`in`.IOrderRepository
import com.devback.demo.order.domain.Order
import com.devback.demo.order.domain.OrderName
import com.devback.demo.product.adapter.`in`.api.ProductRepository
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class OrderService(private val orderRepository: IOrderRepository, private val productRepository: ProductRepository): IOrdersUseCase {
    override fun getOrders(): ArrayList<Order> {
        orderRepository.add(Order(OrderName("Test1")))
    return orderRepository.getItems()
    }
    override fun create(order: Order): Order {
        orderRepository.add(order)
        return order
    }

    override fun addProduct(id: UUID, productId: UUID): Order? {
        val findProduct = productRepository.data.find { it.id == productId }
        if(findProduct != null) {
            return orderRepository.addProduct(id, findProduct)
        } else {
            return null
        }
    }


    override fun getOrder(id: UUID): Order? {
        return orderRepository.getOrder(id)
    }

    override fun getProducts(id: UUID): ArrayList<Product> {
        return orderRepository.getProducts(id)
    }


}
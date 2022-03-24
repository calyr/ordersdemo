package com.devback.demo.order.application.port

import com.devback.demo.order.application.port.`in`.IOrdersUseCase
import com.devback.demo.order.application.port.`in`.IOrderRepository
import com.devback.demo.order.application.port.out.error.NotFoundException
import com.devback.demo.order.domain.Order
import com.devback.demo.order.domain.OrderName
import com.devback.demo.product.adapter.`in`.api.ProductRepository
import com.devback.demo.product.domain.Product
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class OrderService(private val orderRepository: IOrderRepository, private val productRepository: ProductRepository): IOrdersUseCase {
    override fun getOrders() = orderRepository.getItems()

    override fun create(order: Order): Order {
        orderRepository.add(order)
        return order
    }

    override fun addProduct(id: UUID, productId: UUID): Any? {
        val findProduct = productRepository.data.find { it.id == productId }
        return if(findProduct != null) {
            orderRepository.addProduct(id, findProduct)
        } else {
           throw NotFoundException("The productId doesn't belong in the product list.")
        }
    }


    override fun getOrder(id: UUID): Any {
        return orderRepository.getOrder(id)
    }

    override fun getProducts(id: UUID): ArrayList<Product> {
        return orderRepository.getProducts(id)
    }

    override fun deleteOrder(id: UUID): Any {
        return orderRepository.deleteOrder(id)
    }


}
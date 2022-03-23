package com.devback.demo.order.application.port.out

import com.devback.demo.order.application.port.OrderService
import com.devback.demo.order.domain.Order
import com.devback.demo.order.domain.OrderId
import com.devback.demo.order.domain.OrderItem
import com.devback.demo.order.domain.OrderName
import com.devback.demo.product.domain.Product
import com.devback.demo.product.domain.ProductName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*


@RestController
@RequestMapping("/api/v1/order")
class OrderController(@Autowired val orderService: OrderService) {

    @GetMapping("/test")
    fun test() {
        orderService.save(Order(OrderId(UUID.randomUUID()), OrderName("orden1"), Product(UUID.randomUUID(), ProductName("p1"), BigDecimal(10.99) )))
    }

    @GetMapping
    fun getOrders() = orderService.getOrders()

    @PostMapping
    fun addOrder(@RequestBody order: Order) = ResponseEntity(orderService.save(order), HttpStatus.CREATED)

}
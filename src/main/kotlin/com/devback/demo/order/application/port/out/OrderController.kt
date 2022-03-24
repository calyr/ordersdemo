package com.devback.demo.order.application.port.out

import com.devback.demo.order.application.port.OrderService
import com.devback.demo.order.domain.Order
import com.devback.demo.order.domain.OrderDescription
import com.devback.demo.order.domain.OrderName
import com.devback.demo.product.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/orders")
class OrderController(@Autowired val orderService: OrderService) {

    @GetMapping
    fun getOrders() = orderService.getOrders()

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: UUID) = ResponseEntity(orderService.getOrder(id), HttpStatus.OK)

    @GetMapping("/{id}/products")
    fun getProducts(@PathVariable id: UUID) =  ResponseEntity(orderService.getProducts(id), HttpStatus.OK)

    @PostMapping("/{id}")
    fun addProduct(@PathVariable id: String, @RequestParam productId: UUID) =  ResponseEntity(orderService.addProduct(UUID.fromString(id), productId), HttpStatus.OK)

    @PostMapping
    fun create(@RequestParam name: String, @RequestParam description: String) =  orderService.create( Order(OrderName(name), OrderDescription(description)) )

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Any> = ResponseEntity<Any>(orderService.deleteOrder(id), HttpStatus.OK)

}
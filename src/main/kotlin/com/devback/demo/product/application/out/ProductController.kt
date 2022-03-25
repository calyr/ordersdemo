package com.devback.demo.product.application.out

import com.devback.demo.order.domain.OrderName
import com.devback.demo.product.application.`in`.IProductService
import com.devback.demo.product.domain.Product
import com.devback.demo.product.domain.ProductName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(@Autowired private val productService: IProductService) {

    @GetMapping
    fun getList() = productService.getList()

    @PostMapping
    fun add(@RequestParam name: ProductName, @RequestParam price: BigDecimal): Any = ResponseEntity<Any>(productService.addProduct(Product(name, price)), HttpStatus.OK)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestParam name: ProductName, @RequestParam price: BigDecimal) : ResponseEntity<Any> = ResponseEntity<Any>(productService.updateProduct(id, name, price), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Any> = ResponseEntity<Any>(productService.deleteProduct(id), HttpStatus.OK)

    @PostMapping("/find/name")
    fun findByName(@RequestParam value: OrderName) = productService.findByName(value.value)

}
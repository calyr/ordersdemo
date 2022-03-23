package com.devback.demo.product.application.out

import com.devback.demo.product.application.`in`.IProductRepository
import com.devback.demo.product.application.`in`.IProductService
import com.devback.demo.product.domain.Product
import com.devback.demo.product.domain.ProductName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/api/v1/product")
class ProductController(@Autowired private val productService: IProductService) {

    @GetMapping
    fun getList() = productService.getList()

    @PostMapping
    fun add(@RequestBody product: Product) : ResponseEntity<Product> {
        println(product)
//        return ResponseEntity<Product>(productService.addProduct(Product(UUID.randomUUID(), ProductName("Product1"), BigDecimal(15.61) )), HttpStatus.OK)
        return ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK)
    }
}
package com.devback.demo.product.application.out

import com.devback.demo.product.application.`in`.IProductService
import com.devback.demo.product.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/product")
class ProductController(@Autowired private val productService: IProductService) {

    @GetMapping
    fun getList() = productService.getList()

    @PostMapping
    fun add(@RequestBody product: Product) : ResponseEntity<Product> = ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK)

    @PutMapping()
    fun update(@RequestBody product: Product) : ResponseEntity<Product> = ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK)


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Product> = ResponseEntity<Product>(productService.deleteProduct(id), HttpStatus.OK)

}
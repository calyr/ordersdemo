package com.devback.demo.product.application.out

import com.devback.demo.order.application.port.out.error.NotFoundException
import com.devback.demo.order.domain.OrderDescription
import com.devback.demo.order.domain.OrderName
import com.devback.demo.product.application.`in`.IProductService
import com.devback.demo.product.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/products")
class ProductController(@Autowired private val productService: IProductService) {

    @GetMapping
    fun getList() = productService.getList()

    @PostMapping
    fun add(@RequestBody product: Product): Any? {
        var response : Any? = null
            try {
                response = ResponseEntity<Any>(productService.addProduct(product), HttpStatus.OK)
            }catch (e: Exception) {
                e.message?.let { NotFoundException(it) }
            }
        return response

    }

    @PutMapping()
    fun update(@RequestBody product: Product) : ResponseEntity<Any> = ResponseEntity<Any>(productService.updateProduct(product), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Any> = ResponseEntity<Any>(productService.deleteProduct(id), HttpStatus.OK)

    @PostMapping("/find/name")
    fun findByName(@RequestParam value: OrderName) = productService.findByName(value.value)

}
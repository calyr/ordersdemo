package com.devback.demo.product.adapter.`in`.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController {

    @PostMapping
    fun add() {
    }
}
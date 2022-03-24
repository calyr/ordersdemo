package com.devback.demo.product.domain

import com.devback.demo.order.application.port.out.error.BadRequestException
import org.jetbrains.annotations.NotNull
import org.springframework.boot.autoconfigure.domain.EntityScan
import java.math.BigDecimal
import java.util.*

data class Product(val name: ProductName, val price: BigDecimal) {
    val id: UUID = UUID.randomUUID()
    init {
        require( price > BigDecimal.ZERO) {
            "The price must be >= 0."
        }
        requireNotNull(price) {
            "The price is required."
        }
        requireNotNull(name) {
            "The name is required"
        }
    }
}
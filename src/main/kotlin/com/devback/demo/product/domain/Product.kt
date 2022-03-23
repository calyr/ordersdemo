package com.devback.demo.product.domain

import java.math.BigDecimal
import java.util.*

data class Product(val name: ProductName, val price: BigDecimal) {
    val id: UUID = UUID.randomUUID()
}
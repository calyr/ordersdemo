package com.devback.demo.product.domain

import java.math.BigDecimal
import java.util.*

data class Product(val id: UUID, val name: ProductName, val price: BigDecimal)
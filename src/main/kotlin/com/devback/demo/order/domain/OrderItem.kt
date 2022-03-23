package com.devback.demo.order.domain

import com.devback.demo.product.domain.Product
import java.math.BigDecimal
import java.util.*

class OrderItem(product: Product) {
    var productId: UUID
    var price: BigDecimal

    init {
        productId = product.id
        price = product.price
    }
}
package com.devback.demo.order.domain

import com.devback.demo.product.domain.Product
import java.math.BigDecimal
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

data class Order(val name: OrderName, val description: OrderDescription) {
    var id: UUID = UUID.randomUUID()
    var total: BigDecimal = BigDecimal("00.00")
    var items: ArrayList<Product> = arrayListOf()
    var timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.of("-04:00")).format(Instant.now())

    init {
        require( name != null) {
            "the Order name cannot be null"
        }
    }

    fun addProduct(product: Product) {
        items.add(product)
        total = total.add(product.price)
    }
}


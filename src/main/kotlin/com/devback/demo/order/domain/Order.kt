package com.devback.demo.order.domain

import com.devback.demo.product.domain.Product
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList

data class Order(val name: OrderName) {
    var id: UUID = UUID.randomUUID()
    var total: BigDecimal = BigDecimal("00.00")
    var items: ArrayList<Product> = arrayListOf()

    fun addProduct(product: Product) {
        items.add(product)
        total = total.add(product.price)
    }
}


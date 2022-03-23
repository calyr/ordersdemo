package com.devback.demo.order.domain

import com.devback.demo.product.domain.Product
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList

data class Order(val id: OrderId,val name: OrderName, val product: Product) {
    var price: BigDecimal
    var items: ArrayList<OrderItem>

    init {
        items = arrayListOf(OrderItem(product))
        price = product.price
    }

    fun addProduct(product: Product) {
        items.add(OrderItem(product))
        price = price.add(product.price)
    }
}


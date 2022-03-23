package com.devback.demo.order.domain

import java.util.*

data class OrderId(val value: UUID)  {
    override fun toString(): String = value.toString()
    fun withId(id: String) : OrderId = OrderId(UUID.fromString(id) )
    fun withoutId() : OrderId = OrderId(UUID.randomUUID())
}
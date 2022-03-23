package com.devback.demo.order.domain

import java.util.*

data class OrderId(val value: UUID)  {
    init {
        require(pattern.matches(value.toString())) {
            "The Id $value does not correct with the pattern $pattern."
        }
    }
    override fun toString(): String = value.toString()

    fun withId(id: String) : OrderId = OrderId(UUID.fromString(id) )

    fun withoutId() : OrderId = OrderId(UUID.randomUUID())

}


val pattern = "[a-z0-9]{10}".toRegex()

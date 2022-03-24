package com.devback.demo.order.domain

data class OrderName( val value: String) {
    init {
        require( value != null) {
            "Order name is required."
        }
        require(value.length >= 4) {
            "Order name must more than 4 characters."
        }
    }
}
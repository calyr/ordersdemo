package com.devback.demo.order.domain

class OrderDescription( val value: String) {
    init {
        require( value != null) {
            "Order description is required."
        }
        require(value.length >= 5) {
            "Order description must more than 5 characters."
        }
    }
}
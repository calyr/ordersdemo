package com.devback.demo.order.domain

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize
data class OrderName( val value: String) {
    init {
        require( value != null) {
            "Order name is required."
        }
        require(value.length >= 1) {
            "Order name must more than 4 characters."
        }
    }
}
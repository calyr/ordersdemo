package com.devback.demo.product.domain

import javax.validation.constraints.NotEmpty

data class ProductName(val value: String) {
    init {
        requireNotNull(value) {
            "The name is required"
        }
        require( value.length >= 4) {
            "The name must be more 4 letter."
        }
    }
}

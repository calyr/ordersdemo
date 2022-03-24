package com.devback.demo.order.application.port.out.error

data class ErrorMessage(private val exception: Exception, val code: Int) {
    val message = exception.message
}

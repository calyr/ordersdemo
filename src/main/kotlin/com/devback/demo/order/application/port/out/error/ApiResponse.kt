package com.devback.demo.order.application.port.out.error

import com.fasterxml.jackson.annotation.JsonProperty


class ApiResponse(
    val statusCode: Int = 0,
    val message: String?,
    val result: Any?
)

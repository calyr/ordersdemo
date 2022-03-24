package com.devback.demo.order.application.port.out.error

class BadRequestException(val detail: String): RuntimeException( "BAD REQUEST EXCEPTION " + detail)
package com.devback.demo.order.application.port.out.error

class NotFoundException (detail: String): RuntimeException( "NOT FOUND " + detail)
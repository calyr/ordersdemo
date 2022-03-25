package com.devback.demo.order.application.port.out.error

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import java.util.stream.Collectors


@ControllerAdvice
class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler( NotFoundException::class)
    @ResponseBody
    fun notFoundRequest(exception: Exception): ApiResponse {
        return ApiResponse(HttpStatus.NOT_FOUND.value(), exception.message, null)
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun exception(exception: Exception): ApiResponse { // The error must be corrected
        exception.printStackTrace()
        return ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.message, null)
    }
}
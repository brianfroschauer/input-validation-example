package com.example.inputvalidation.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [NotFoundException::class])
    fun handle(exception: NotFoundException, request: HttpServletRequest): ResponseEntity<ApiError> {
        return ResponseEntity(
                ApiError(
                        Date(),
                        HttpStatus.NOT_FOUND.value(),
                        "Resource not found",
                        request.requestURI),
                HttpStatus.NOT_FOUND
        )
    }
}

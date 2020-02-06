package example.spring.retry.exception.handler

import example.spring.retry.exception.RetryException
import example.spring.retry.model.ExceptionResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {
    private val logger: Logger = LoggerFactory.getLogger(ErrorHandler::class.java)

    @ExceptionHandler(RetryException::class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    fun handle(ex: RetryException): ExceptionResponse {
        logger.error("Retry Exception", ex)
        return ExceptionResponse(ex.message)
    }
}

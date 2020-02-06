package example.spring.retry.controller

import example.spring.retry.service.RetryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/retry")
class RetryController(private val retryService: RetryService) {
    @GetMapping
    fun call() = retryService.retryExample()
}

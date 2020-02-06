package example.spring.retry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class SpringRetryApplication

fun main(args: Array<String>) {
    runApplication<SpringRetryApplication>(*args)
}

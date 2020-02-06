package example.spring.retry.service

import example.spring.retry.exception.RetryException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service

@Service
class RetryService {
    private val logger: Logger = LoggerFactory.getLogger(RetryService::class.java)
    private var attempt = 0

    @Retryable(value = [RetryException::class], maxAttempts = 4, backoff = Backoff(3000))
    fun retryExample(): String? {
        logger.info("ActionLog.retryExample.start")
        attempt++
        logger.info("ATTEMPT = $attempt")
        when (attempt) {
            in 1..2 -> throw RetryException("exception.recover-attempts-failed")
            else -> {
                logger.info("ActionLog.retryExample.success")
                return "success"
            }
        }
    }
}

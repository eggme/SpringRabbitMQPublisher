package com.example.springrabbitmqpublisher.linstener

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class SampleListener {

    private var logger = LoggerFactory.getLogger(SampleListener::class.java)

    @RabbitListener(queues = ["movv.queue"])
    fun reciveMessage(message: Message) {
        logger.info("$message")
    }
}
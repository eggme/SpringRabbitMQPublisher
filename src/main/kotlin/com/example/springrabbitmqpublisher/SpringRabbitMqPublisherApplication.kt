package com.example.springrabbitmqpublisher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringRabbitMqPublisherApplication

fun main(args: Array<String>) {
    runApplication<SpringRabbitMqPublisherApplication>(*args)
}

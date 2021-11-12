package com.example.sender.module

import org.springframework.amqp.core.ExchangeTypes
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.annotation.Queue
import org.springframework.amqp.rabbit.annotation.QueueBinding
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ReceiverModule {

    @RabbitListener(bindings = [QueueBinding(
        exchange = Exchange(name = "dept", type = ExchangeTypes.TOPIC),
        value = Queue(name = "dept-fourth"),
        key = ["dept-third"]
    )])
    fun receiver(dept: Dept) {
        println("4 =====> $dept")
    }

}
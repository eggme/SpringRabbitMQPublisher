package com.example.receiver.module

import org.springframework.amqp.core.ExchangeTypes
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.annotation.Queue
import org.springframework.amqp.rabbit.annotation.QueueBinding
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class Receiver {

    @RabbitListener(bindings = [QueueBinding(
        exchange = Exchange(name = "movv", type = ExchangeTypes.TOPIC),
        value = Queue(name = "movv-second"),
        key = ["movv-first"]
    )])
    fun receiver1(msg: String) {
        println("receive ==> $msg, ${LocalDateTime.now()}")
    }

    @RabbitListener(bindings = [QueueBinding(
        exchange = Exchange(name = "dept", type = ExchangeTypes.TOPIC),
        value = Queue(name = "dept-second"),
        key = ["dept-first"]
    )])
    @SendTo("dept/dept-third")
    fun reciver2(dept : Dept): Dept{
        println("2 ====> $dept")

        var anotherDept = Dept(20, "new", "new", "")
        println("3 ====? ${anotherDept}")
        return dept
    }
}
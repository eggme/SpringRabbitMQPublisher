package com.example.sender.module

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class SenderModule {

    @Autowired private lateinit var rabbitTemplate: RabbitTemplate
    @Autowired private lateinit var mapper: ObjectMapper

    //@Scheduled(fixedRate = 1000)
    fun sender1() {
        println("주기적으로 호출되니?")
        val now = LocalDateTime.now()
        println("sender 1 ==>  $now")
        rabbitTemplate.convertAndSend("movv", "movv-first", now.toString())
    }

    @Scheduled(fixedRate = 1000)
    fun sender2() {
        val now = LocalDateTime.now()
        var dept = Dept(10, "test", "test", now.toString())
        println("sender 1 ==>  $dept")

        rabbitTemplate.convertAndSend("dept", "dept-first", dept)
    }
}
package com.example.sender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class SenderApplication

fun main(args: Array<String>) {
    runApplication<SenderApplication>(*args)
}
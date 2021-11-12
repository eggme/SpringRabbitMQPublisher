package com.example.receiver.config

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory

@Configuration
class RabbitMQConfig: RabbitListenerConfigurer {

    override fun configureRabbitListeners(registrar: RabbitListenerEndpointRegistrar) {
        registrar.messageHandlerMethodFactory = messageHandlerMethodFactory()
    }

    @Bean
    fun messageHandlerMethodFactory(): MessageHandlerMethodFactory {
        return DefaultMessageHandlerMethodFactory().apply {
            this.setMessageConverter(jsonMessageConverter())
        }
    }

    @Bean
    fun jsonMessageConverter(): MappingJackson2MessageConverter {
        return MappingJackson2MessageConverter()
    }

    @Bean
    fun messageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }
}
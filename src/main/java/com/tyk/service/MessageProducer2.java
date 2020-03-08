package com.tyk.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageProducer2")
public class MessageProducer2 {
    @Resource(name = "amqpTemplate")
    private AmqpTemplate amqpTemplate;

    public void onSendMessage(Object o) {
        amqpTemplate.convertAndSend("queueTestKey",o);
    }
}


package com.tyk.service;

import com.tyk.pojo.Spittle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AlertServiceImpl implements AlertService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public AlertServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        rabbitTemplate.convertAndSend("spittleExchange","spittleRoutingKey",spittle);
    }
}

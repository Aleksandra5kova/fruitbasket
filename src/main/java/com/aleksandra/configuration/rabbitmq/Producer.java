package com.aleksandra.configuration.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
    RabbitTemplate rabbitTemplate;

    public void send(Notification notification) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(GlobalConfig.DISTRIBUTION_EXCHANGE, notification.getType(), notification.getMessage());
    }

}

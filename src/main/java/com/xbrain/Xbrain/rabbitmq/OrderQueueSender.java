package com.xbrain.Xbrain.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xbrain.Xbrain.model.entity.Pedido;
 
@Component
public class OrderQueueSender {
 
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;
 
    public void send(String order) {
    	this.rabbitTemplate.convertAndSend(queue.getName(), order);
    }
}
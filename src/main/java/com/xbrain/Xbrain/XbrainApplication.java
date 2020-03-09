package com.xbrain.Xbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableRabbit
public class XbrainApplication {
	
	@Value("${queue.order.name}")
    private String orderQueue;

	public static void main(String[] args) {
		SpringApplication.run(XbrainApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(orderQueue, true);
    }

}

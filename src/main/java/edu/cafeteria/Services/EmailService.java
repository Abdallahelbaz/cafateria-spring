package edu.cafeteria.Services;
  

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cafeteria.configuration.RabbitMQConfig;

@Service
public class EmailService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderReadyNotification(Long idClient) {
    	
         rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, idClient);
    	
          System.out.println("Notification sent to: " + idClient);
    }
}


package edu.cafeteria.listener;

//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import edu.cafeteria.configuration.RabbitMQConfig;

@Service
public class EmailListener {

//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String email) {
        // Simulate email sending
        System.out.println("Sending email to: " + email);
    }
}

package edu.cafeteria.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import edu.cafeteria.Services.NotificationService;
import edu.cafeteria.Services.OrderService; 
import edu.cafeteria.configuration.RabbitMQConfig; 
import edu.cafeteria.model.Notification;
import edu.cafeteria.model.Order;

@Service
public class EmailListener {

	
	 @Autowired
	    private OrderService orderService; 
	    @Autowired
	    private NotificationService notificationService; 
	     
	    
	    
	    
	    
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(Long message) {
    	
    	
    	 Order o =	orderService.getOrderById(message);
    	 Notification not=new Notification(o, "your order is ready to take, thank you for your confidence!");
    	 notificationService.createNotification(not);
     
     	
        System.out.println("Sending email to: " + message);
    }
}

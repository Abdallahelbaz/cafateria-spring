
package edu.cafeteria.configuration;
 

//import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "cafeteria-exchange";
    public static final String ROUTING_KEY = "cafeteria.routingkey";
    public static final String QUEUE = "cafeteria-queue";

//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE, false);
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange(EXCHANGE);
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
//    }
}


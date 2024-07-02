package edu.cafeteria.Services;
 

import edu.cafeteria.model.Order;
import edu.cafeteria.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void markAsReady(Order order) {
        // Logic to mark the order as ready
        // This could be a status field in the Order entity
        order.setStatus(true);
        orderRepository.save(order);
    }
}


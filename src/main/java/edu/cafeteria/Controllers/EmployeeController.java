package edu.cafeteria.Controllers;
 

import edu.cafeteria.model.Order;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employee/orders")
public class EmployeeController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private EmailService    emailService;

    @GetMapping
    public String viewOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() != Role.EMPLOYEE) {
            return "redirect:/auth/login";
        }

        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/ready/{orderId}")
    public String markOrderReady(@PathVariable Long orderId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() != Role.EMPLOYEE) {
            return "redirect:/auth/login";
        }

        Order order = orderService.getOrderById(orderId);
       
        orderService.markAsReady(order);
        emailService.sendOrderReadyNotification(order.getUser().getEmail());

        return "redirect:/employee/orders";
    }
    
    @PostMapping("/employee/orders/ready")
    public String markOrderAsReady(@RequestParam("orderId") Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            orderService.markAsReady(order);
            emailService.sendOrderReadyNotification(order.getUser().getEmail());
        }
        return "redirect:/employee/orders";
    }
    
    
}


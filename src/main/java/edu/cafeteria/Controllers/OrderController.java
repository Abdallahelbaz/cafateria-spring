package edu.cafeteria.Controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cafeteria.DTO.OrderDTO;
import edu.cafeteria.Repos.OrderRepository;
import edu.cafeteria.Services.EmailService;
import edu.cafeteria.Services.OrderService;
import edu.cafeteria.model.Item;
import edu.cafeteria.model.Order;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;


    public List<Item> items;

    @GetMapping("/new")
    public String viewNewOrders(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.guest || user.getRole() == Role.staff) {
            return "redirect:/auth/login";
        }

        model.addAttribute("orders", orderService.getOrdersByStatus("NEW"));
        return "newOrders";
    }

    @GetMapping("/preparation")
    public String viewOnPreparationOrders(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.guest || user.getRole() == Role.staff) {
            return "redirect:/auth/login";
        }
        model.addAttribute("orders", orderService.getOrdersByStatus("PREPARATION"));
        return "onPreparationOrders";
    }


    @GetMapping("/ready")
    public String viewReadyToTakeOrders(Model model, HttpSession session) {


        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.guest || user.getRole() == Role.staff) {
            return "redirect:/auth/login";
        }


        model.addAttribute("Userid", user.getId());
        model.addAttribute("orders", orderService.getOrdersByStatus("READY"));
        return "readyToTakeOrders";
    }

    @PostMapping("/prepare")
    public String moveToPreparation(@RequestParam Long orderId) {
        orderService.updateOrderStatus(orderId, "PREPARATION");
        return "redirect:/orders/new";
    }

    @PostMapping("/ready")
    public String moveToReady(@RequestParam Long orderId) {
        orderService.updateOrderStatus(orderId, "READY");
        return "redirect:/orders/preparation";
    }

    @PostMapping("/complete")
    public String completeOrder(@RequestParam Long orderId) {
        orderService.updateOrderStatus(orderId, "COMPLETE");
        return "redirect:/orders/ready";
    }


    @GetMapping("/{id}")
    public String viewOrder(@PathVariable("id") Long id, Model model, HttpSession session) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            OrderDTO orderDTO = new OrderDTO();

            orderDTO = convertToDTO(order.get());

            Long idd = (Long) ((User) session.getAttribute("user")).getId();
            System.out.println("ppppppppppppppppppp" + idd);
            model.addAttribute("userID", idd);

            model.addAttribute("items", items);
            model.addAttribute("order", orderDTO);
            return "viewOrder";
        } else {

            model.addAttribute("errorMessage", "Order not found");
            return "error";
        }
    }

    @PostMapping("/setPreparing/{id}")
    public String setOrderPreparing(@PathVariable Long id) {
        orderService.updateOrderStatus(id, "PREPARATION");
        return "redirect:/orders/new";
    }


    @PostMapping("/setReady/{id}")
    public String setOrderReady(@PathVariable Long id) {
        Order o = orderService.getOrderById(id);

        orderService.updateOrderStatus(id, "READY");
        emailService.sendOrderReadyNotification(o.getId());

        return "redirect:/orders/preparation";
    }


    @PostMapping("/setToken/{id}")
    public String setOrderTOKEN(@PathVariable Long id) {
        orderService.updateOrderStatus(id, "TOKEN");
        return "redirect:/orders/ready";
    }


    @PostMapping("/NOTIFY/{idClient}/{idOrder}")
    public String NOTIFYClient(@PathVariable Long idClient, @PathVariable Long idOrder) {


        emailService.sendOrderReadyNotification(idOrder);

        return "redirect:/orders/ready";
    }

    @PostMapping("/feedback/{orderId}")
    public String submitFeedback(@PathVariable Long orderId, @RequestParam int rating, HttpSession session) {
        Order order = orderService.findOrderById(orderId).get();
        order.setRating(rating);
        orderService.save(order);

        User user = (User) session.getAttribute("user");
        session.setAttribute("user", user);

        return "redirect:/";

    }


    private OrderDTO convertToDTO(Order order) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setItems(order.getItems());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setUser(order.getUser());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }


    @GetMapping("/staffOrders/{id}")
    public String viewStaffOrders(@PathVariable("id") Long id, Model model) {

        List<Order> FiltredList = new ArrayList<>();

        List<Order> originalList = orderService.getAllOrders();
        for (int i = 0; i < originalList.size(); i++) {
            if (originalList.get(i).getUser().getId() == id) {
                FiltredList.add(originalList.get(i));
            }
        }

        model.addAttribute("allOrdersDTO", FiltredList);


        System.out.println("ZZZZZZZZZZZZZZallOrdersDTO" + orderService.getAllOrders().get(0).getStatus());
        return "staffOrders";
    }

    @GetMapping("/guestOrders/{id}")
    public String viewGuestOrders(@PathVariable("id") Long id, Model model) {
        List<Order> FiltredList = new ArrayList<>();
        ;
        List<Order> originalList = orderService.getAllOrders();
        for (int i = 0; i < originalList.size(); i++) {
            if (originalList.get(i).getUser().getId() == id) {
                FiltredList.add(originalList.get(i));
            }
        }
        model.addAttribute("allOrdersDTO", FiltredList);
        return "guestOrders";
    }
}

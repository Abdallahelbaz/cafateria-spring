package edu.cafeteria.Controllers;
 

import edu.cafeteria.model.*;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderService orderService;
    

    @GetMapping
    public String viewProducts(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }

        List<Item> items = productService.getAllItems();
        model.addAttribute("items", items);
        return "products";
    }

    @GetMapping("/order/{itemId}")
    public String orderProduct(@PathVariable Long itemId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.EMPLOYEE) {
            return "redirect:/auth/login";
        }

        Item item = productService.getItemById(itemId);
        if (user.getRole() == Role.STAFF) {
            item.setPrice((float) (item.getPrice() * 0.8)); // 20% discount
        }
        model.addAttribute("item", item);
        return "order";
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam Long itemId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.EMPLOYEE) {
            return "redirect:/auth/login";
        }

        Item item = productService.getItemById(itemId);
        Order order = new Order();
        order.setItem(item);
        order.setUser(user);
        order.setOrderDate(   new Date(System.currentTimeMillis()));
       
        orderService.save(order);

        model.addAttribute("order", order);
        return "order_confirmation";
    }
}


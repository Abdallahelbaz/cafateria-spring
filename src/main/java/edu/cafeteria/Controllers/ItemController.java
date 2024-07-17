package edu.cafeteria.Controllers;
 

import edu.cafeteria.model.Item; 
import edu.cafeteria.model.User; 
import edu.cafeteria.model.Role; 
import edu.cafeteria.model.Order; 
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private OrderService orderService;
    @Autowired
    private LogService logService;

    @GetMapping
    public String viewProducts(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }

        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("user", user);
        return "items";
//    	 User user = (User) session.getAttribute("user");
//    	    if (user == null) {
//    	        return "redirect:/auth/login";
//    	    }
//
//    	    List<Item> items = itemService.getAllItems();
//    	    model.addAttribute("items", items);
//    	    model.addAttribute("user", user);
//    	    return "items";
    }

    @GetMapping("/order/{itemId}")
    public String orderProduct(@PathVariable Long itemId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.employee) {
            return "redirect:/auth/login";
        }

        Item item = itemService.getItemById(itemId);
        if (user.getRole() == Role.staff) {
            item.setPrice((float) (item.getPrice() * 0.8)); // 20% discount
        }
        model.addAttribute("item", item);
        return "order";
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam Long itemId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole() == Role.employee) {
            return "redirect:/auth/login";
        }

       List<Item>  items = itemService.getAllItems( );
        Order order = new Order();
        order.setItems(items);
        order.setUser(user);
        order.setOrderDate(   new Date(System.currentTimeMillis()));
        order.setStatus("NEW");
        
        orderService.save(order);

        model.addAttribute("order", order);
        return "order_confirmation";
    }
    
    
    
    
    
    ///crud
    @GetMapping("/new")
    public String createItemForm(Model model) {
    	
        model.addAttribute("item", new Item());
        return "item_form";
    }

    @PostMapping
    public String saveItem(@ModelAttribute("item") Item item, HttpSession session) {
    	User user = (User) session.getAttribute("user");
    	if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
    	logService.log(user.getUserName(), "added the item " + item.getName(),user.getRole().name());
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "itemUpdateForm";
    }

    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute("item") Item item, HttpSession session) {
//        Item existingItem = itemService.getItemById(id);
//        if (existingItem != null) {
//        	existingItem.setName(item.getName());
//        
//        existingItem.setPhotoUrl(item.getPhotoUrl());
//        existingItem.setPrice(item.getPrice());
//
//        itemService.saveItem(existingItem);
//        }
    	User user = (User) session.getAttribute("user");
    	if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
    	 logService.log(user.getUserName(), "edited the item " + item.getName(),user.getRole().name()  );
         
    	  itemService.updateItem(id, item);
    	  
    	  return "redirect:/items";//  return "/items/delete/"+id;
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id, HttpSession session) {
    	User user = (User) session.getAttribute("user");
    	if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
    	 logService.log(user.getUserName(), "deleted the item with id: " + id ,user.getRole().name() );
    	itemService.deleteItem(id);
        return "redirect:/items";
    }
}


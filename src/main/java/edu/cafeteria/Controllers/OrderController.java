package edu.cafeteria.Controllers; 


import edu.cafeteria.model.Item;
import edu.cafeteria.model.Order;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
import edu.cafeteria.DTO.OrderDTO;
import edu.cafeteria.Repos.OrderRepository;
import edu.cafeteria.Services.*;
import edu.cafeteria.converter.OrderConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService; 
    @Autowired
    private EmailService emailService; 
    
    
    
    public List <Item> items;
    
    @GetMapping("/new") 
    public String viewNewOrders(Model model,  HttpSession session) {
    	
    	 User user = (User) session.getAttribute("user");
       if (user == null || user.getRole() == Role.guest|| user.getRole() == Role.staff) {
           return "redirect:/auth/login";
       }
    	
        model.addAttribute("orders", orderService.getOrdersByStatus("NEW"));
        return "newOrders";
    }

    @GetMapping("/preparation")
    public String viewOnPreparationOrders(Model model,  HttpSession session) {
    	
    	 User user = (User) session.getAttribute("user");
         if (user == null || user.getRole() == Role.guest|| user.getRole() == Role.staff) {
             return "redirect:/auth/login";
         }
      	
         
         
         
        model.addAttribute("orders", orderService.getOrdersByStatus("PREPARATION"));
        return "onPreparationOrders";
    }


    @GetMapping("/ready")
       public String viewReadyToTakeOrders(Model model,  HttpSession session) {
       	
       	
       	 User user = (User) session.getAttribute("user");
            if (user == null || user.getRole() == Role.guest|| user.getRole() == Role.staff) {
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
    
    
    
    
    
    //
    @GetMapping("/{id}")
    public String viewOrder(@PathVariable("id") Long id, Model model, HttpSession session) {
        Optional<Order> order = orderRepository.findById(id);
         
        if (order.isPresent()) {
            OrderDTO orderDTO = new OrderDTO();
            // Convert order to OrderDTO (assuming you have a method to do this)
            orderDTO = convertToDTO(order.get());
            
            Long idd=(Long) ((User) session.getAttribute("user")).getId();
            System.out.println("ppppppppppppppppppp"+idd);
            model.addAttribute("userID", idd); 
           
            model.addAttribute("items", items);
            model.addAttribute("order", orderDTO);
            return "viewOrder";
        } else {
            // Handle the case where the order is not found
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
    	Order o =orderService.getOrderById(id);
    	
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
    public String NOTIFYClient(@PathVariable Long  idClient,@PathVariable Long idOrder) {
       System.out.println("2222222222222222222222222222222222222222222222222222222"
       		+ "cleint id:"+idClient+" notified about the order : "+idOrder);
       //
       String email=  userService.findById(idClient).get().getEmail();
       
       emailService.sendOrderReadyNotification(idOrder);
       //
       System.out.println("7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777"
          		+ "cleint id:"+idClient+" notified about the order : "+idOrder);
        return "redirect:/orders/ready";
    }
    
    @PostMapping("/feedback/{orderId}")
    public String submitFeedback(@PathVariable Long orderId, @RequestParam int rating, HttpSession session) {
        Order order = orderService.findOrderById(orderId).get();
        order.setRating(rating);
        orderService.save(order);
        
        User user = (User) session.getAttribute("user");
        session.setAttribute("user",user);
//        if (  user.getRole() == Role.guest  ) {
//        	 Long idd=(Long) ((User) session.getAttribute("user")).getId();
//             
//             model.addAttribute("userID", idd);
//             
//            model.addAttribute("MaskedEMail",maskEmail(MaskedEMail)  ); 
//             model.addAttribute("items", itemService.getAllItems());
//        	return "HomeGuest"; 
//        } else if(user.getRole() == Role.staff)  {
//        	return "HomeStaff";
//        }else {
//        	return "redirect:/auth/login";
//        }
        return "redirect:/";
         
    } 
//    @GetMapping("/delete/{id}")
//    public String deleteOrder(@PathVariable("id") Long id, Model model) {
//        Optional<Order> order = orderRepository.findById(id);
//        if (order.isPresent()) {
//            orderRepository.delete(order.get());
//            return "redirect:/orders/staffOrders"; // Assuming you have a list of orders page
//        } else {
//            // Handle the case where the order is not found
//        	System.out.println("eeeeeeeeeeeeeeeeee"+id);
//            model.addAttribute("errorMessage", "Order not found");
//            return "error";
//        }
//    }

    private OrderDTO convertToDTO(Order order) {
        // Implement the conversion from Order to OrderDTO
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setItems(order.getItems());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setUser(order.getUser());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }
    
    //
    
    
    
    
    
    
    
    @GetMapping("/staffOrders/{id}")
    public String viewStaffOrders(@PathVariable("id") Long id,Model model/*, HttpSession session*/) {
//    	  User user = (User) session.getAttribute("user");
//          if (user == null || user.getRole() == Role.employee) {
//              return "redirect:/auth/login";
//          }
          
          
       //   model.addAttribute("items", orderConverter.modelToDto(orderService.getAllOrders( )));
        // model.addAttribute("newOrders", orderService.getOrdersByStatus("NEW"));
       //  model.addAttribute("allOrdersDTO", orderConverter.modelToDto(orderService.getAllOrders( )));
    	List <Order> FiltredList =new ArrayList<>();   ;
    	 
    	List <Order> originalList=orderService.getAllOrders( );
    	for(int i=0;i<originalList.size();i++) {
    		if(originalList.get(i).getUser().getId()==id) {
    			FiltredList.add(originalList.get(i));
    		}
    	}
    	
    	model.addAttribute("allOrdersDTO",  FiltredList );
         
         
         System.out.println("ZZZZZZZZZZZZZZallOrdersDTO"+orderService.getAllOrders( ).get(0).getStatus());
        return "staffOrders";
    }
     
    
    
    
    
    
    
    
    @GetMapping("/guestOrders/{id}")
    public String viewGuestOrders(@PathVariable("id") Long id,Model model) {
    	List <Order> FiltredList =new ArrayList<>();   ;
   	 
    	List <Order> originalList=orderService.getAllOrders( );
    	for(int i=0;i<originalList.size();i++) {
    		if(originalList.get(i).getUser().getId()==id) {
    			FiltredList.add(originalList.get(i));
    		}
    	}
    	
    	model.addAttribute("allOrdersDTO",  FiltredList );
         
      //  model.addAttribute("orders", orderService.getOrdersByStatus("NEW"));
        return "guestOrders";
    }
}

package edu.cafeteria.Controllers;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cafeteria.Services.CartService;
import edu.cafeteria.Services.ItemService;
import edu.cafeteria.Services.LogService;
import edu.cafeteria.Services.OrderService;
import edu.cafeteria.model.Cart;
import edu.cafeteria.model.CartItem;
import edu.cafeteria.model.Item;
import edu.cafeteria.model.Order;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;


@Controller
@RequestMapping("/payment")
public class PaymentController {
	 @Autowired
	    private LogService logService;
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	
	@Autowired
	private ItemService itemService;

	public Double totalPrice;
	public List<CartItem>  items;
	
	
	
@GetMapping
public String viewCart(Model model, HttpSession session) {
    String userEmail = ((User) session.getAttribute("user")).getEmail();
    Cart cart = cartService.getCart(userEmail);

    model.addAttribute("userRole", ((User) session.getAttribute("user")).getRole().name());  
    model.addAttribute("cart", cart);
    return "payment";
}



@PostMapping("/complete")
    public String completePayment(@RequestParam String paymentMethod,
                                  @RequestParam(required = false) String cardNumber,
                                  @RequestParam(required = false) String expiryDate,
                                  @RequestParam(required = false) String cvv,
                                  HttpSession session,Model model) {
        
	 User user = (User) session.getAttribute("user");
     if (user == null || user.getRole() == Role.employee) {
         return "redirect:/auth/login";
     }


    List<Item>  items = itemService.getAllItems( ); //
    
     Order order = new Order();
     order.setItems(items);
     order.setUser(user);
     order.setOrderDate(   new Date(System.currentTimeMillis()));
     order.setStatus("NEW");
     order.setTotalPrice(totalPrice);
     order.setItems(items);
     
     orderService.save(order);

	
      
        String userEmail = ((User) session.getAttribute("user")).getEmail();
        cartService.clearCart(userEmail);
        Long idd=(Long) ((User) session.getAttribute("user")).getId();
        System.out.println("ppppppppppppppppppp"+idd);
        model.addAttribute("userID", idd); 
        model.addAttribute("userRole", ((User) session.getAttribute("user")).getRole().name()); 
        System.out.println("paymentMethod"+paymentMethod);
		
          logService.log(user.getEmail(), "procedded  to payement ("+paymentMethod+") "
          		                        + "| order ID:"+order.getId(),user.getRole().name()  );
           
        if(paymentMethod.compareTo("cash")      ==0) {
        	  	
        	return "payementOnTheCafeteriaOkay";
			
        }else
				
        	return "payementSuccesWithCard";
    }








}

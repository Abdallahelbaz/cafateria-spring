package edu.cafeteria.Controllers;
import edu.cafeteria.model.Cart;
import edu.cafeteria.model.Item;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.User;
import edu.cafeteria.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/cart")
public class CartController {
	 @Autowired
	    private LogService logService;
	 @Autowired
	    private ItemService itemService;
    @Autowired
    private CartService cartService;
    @Autowired
    private PaymentController paymentController;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long itemId, HttpSession session) {
        String userEmail = ((User) session.getAttribute("user")).getEmail();
        User user= (User) session.getAttribute("user");
        Item item= itemService.getItemById(itemId);
        
        logService.log(user.getUserName(), "added the item " + item.getName() +" to the cart",user.getRole().name()  );
        
        cartService.addToCart(userEmail, itemId);
        
        return "redirect:/HomeStaff";
    }
    
    @PostMapping("/addToGuest")
    public String addToCartGuest(@RequestParam Long itemId, HttpSession session) {
        String userEmail = ((User) session.getAttribute("user")).getEmail();
        User user= (User) session.getAttribute("user");
        Item item= itemService.getItemById(itemId);
        logService.log(userEmail, "added the item " + item.getName() +" to the cart",user.getRole().name()  );
        
        cartService.addToCart(userEmail, itemId);
        
        return "redirect:/HomeGuest";
    }
    
    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        String userEmail = ((User) session.getAttribute("user")).getEmail();
        Cart cart = cartService.getCart(userEmail);
       
        paymentController.totalPrice=cart.getTotalPrice();//
        paymentController.items=cart.getItems();
        
        model.addAttribute("userRole", ((User) session.getAttribute("user")).getRole().name());  
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/checkout")
    public String proceedToCheckout() {
       // return "redirect:/payment";
        return "redirect:/payment";
    }
}

package edu.cafeteria.Services;

import edu.cafeteria.model.Item;
import edu.cafeteria.model.Cart; 
import edu.cafeteria.model.User;
import edu.cafeteria.Repos.*;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void addToCart(String userEmail, Long itemId) {
    	Optional<User> u=userRepository.findByEmail(userEmail);
    	
        Cart cart = cartRepository.findByUserEmail(userEmail)
        		
        		.orElse(  new Cart(u.get()) );
        Item item = itemRepository.findById(itemId)
        		
        		.orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + itemId));
        
        cart.addItem(item);
        cart.setTotalPrice(cart.getTotalPrice()+item.getPrice());
        cartRepository.save(cart);
    }
    @Transactional
    public Cart findCartById(Long cartId) {
    	
    	 Cart   c=   cartRepository.findById(cartId) 
                             .orElseThrow(() -> new EntityNotFoundException("Cart with id " + cartId + " not found"));
    	 
    	return c  ;
    }
    public Cart getCart(String userEmail) {
        return cartRepository.findByUserEmail(userEmail).orElse(new Cart(userEmail));
    }


    @Transactional
	public void clearCart(String userEmail) {
    	 Optional<Cart> optionalCart = cartRepository.findByUserEmail(userEmail);
         
         if (optionalCart.isPresent()) {
             Cart cart = optionalCart.get();
             
             
             cart.getItems().clear();
             cart.setTotalPrice(0.0);
             cartRepository.save(cart);
             
             
             
         } else {
             throw new RuntimeException("Cart not found for user with email: " + userEmail);
         }
 		 
	}
}

package edu.cafeteria.DTO;

import java.util.ArrayList;
import java.util.List;
 

import edu.cafeteria.model.CartItem;
import edu.cafeteria.model.User;

public class CartDTO {
	 private Long id;

	    
	    private User user;

	    
	    private List<CartItem> items = new ArrayList<>();

	    private Double totalPrice;

		public CartDTO() {
			super();
			 
		}

		public CartDTO(Long id, User user, List<CartItem> items, Double totalPrice) {
			super();
			this.id = id;
			this.user = user;
			this.items = items;
			this.totalPrice = totalPrice;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<CartItem> getItems() {
			return items;
		}

		public void setItems(List<CartItem> items) {
			this.items = items;
		}

		public Double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}
	    
	    
	    
}

package edu.cafeteria.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cafeteria.model.Cart;
import edu.cafeteria.model.Item;

public class CartItemDTO {
	 private Long id;

	   
	    private Cart cart;
 
	    private Item item;

	    private int quantity;

	    private double totalPrice;

		public CartItemDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CartItemDTO(Long id, Cart cart, Item item, int quantity, double totalPrice) {
			super();
			this.id = id;
			this.cart = cart;
			this.item = item;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
	    
	    
}

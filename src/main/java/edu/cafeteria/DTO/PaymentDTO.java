package edu.cafeteria.DTO;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cafeteria.model.Order;
import edu.cafeteria.model.User;

public class PaymentDTO {
	 private Long id;
 
	    private float totalPrice; 
	    private Order order;
 
	    private User user;

		public PaymentDTO(Long id, float totalPrice, Order order, User user) {
			super();
			this.id = id;
			this.totalPrice = totalPrice;
			this.order = order;
			this.user = user;
		}

		public PaymentDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public float getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}

package edu.cafeteria.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.cafeteria.model.Item;
import edu.cafeteria.model.User;

public class OrderDTO {

	
	 private Long id; 
	     private Date orderDate; 
	 private List< Item> items = new ArrayList<>();
	 private Double totalPrice;
	 private User user;
	   
	     private String status;

		public OrderDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

	 

		public OrderDTO(Date orderDate, List<Item> items, Double totalPrice, User user, String status) {
			super();
			this.orderDate = orderDate;
			this.items = items;
			this.totalPrice = totalPrice;
			this.user = user;
			this.status = status;
		}



		public OrderDTO(Long id, Date orderDate, List<Item> items, Double totalPrice, User user, String status) {
			super();
			this.id = id;
			this.orderDate = orderDate;
			this.items = items;
			this.totalPrice = totalPrice;
			this.user = user;
			this.status = status;
		}



		public Double getTotalPrice() {
			return totalPrice;
		}



		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	     
	     
	     
	     
	     
}

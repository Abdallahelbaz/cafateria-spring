package edu.cafeteria.DTO;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cafeteria.model.Order;

public class NotificationDTO {
 private Long id;
	 
	 
	
	  
	 private Order order;
	 
	  
    private String message;


	public NotificationDTO(Long id, Order order, String message) {
		super();
		this.id = id;
		this.order = order;
		this.message = message;
	}


	public NotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
}

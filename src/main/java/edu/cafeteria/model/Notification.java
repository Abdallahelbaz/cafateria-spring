package edu.cafeteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Notifications")
public class Notification {
   
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	 
	 
	
	 
	 @ManyToOne
	 @JoinColumn(name = "order_id", referencedColumnName = "id")
	 private Order order;
	 
	 
	 @Column(name = "message")
    private String message;


	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Notification(Order order, String message) {
		super();
		this.order = order;
		this.message = message;
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
    
    

    

    // Getters and setters
}

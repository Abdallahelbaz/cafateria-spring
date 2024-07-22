package edu.cafeteria.model;

import javax.persistence.*;

 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
@Column(name = "orderDate")
    private Date orderDate;

@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
private List< Item> items = new ArrayList<>();

@Column(name = "totalPrice")
private Double totalPrice;


@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;
 

    @Column(name = "status")
    private String status;

    @Column(name = "rating")
    private Integer rating; 
    
    
	public Order() {
		super();
		 
	}


	 


	public Order(Date orderDate, List<Item> items, Double totalPrice, User user, String status) {
		super();
		this.orderDate = orderDate;
		this.items = items;
		this.totalPrice = totalPrice;
		this.user = user;
		this.status = status;
	}





	public Order(Long id, Date orderDate, List<Item> items, Double totalPrice, User user, String status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.items = items;
		this.totalPrice = totalPrice;
		this.user = user;
		this.status = status;
	}





	public Order(Date orderDate, List<Item> items, Double totalPrice, User user, String status, Integer rating) {
		super();
		this.orderDate = orderDate;
		this.items = items;
		this.totalPrice = totalPrice;
		this.user = user;
		this.status = status;
		this.rating = rating;
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


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}





	public Integer getRating() {
		return rating;
	}





	public void setRating(Integer rating) {
		this.rating = rating;
	}
    
    
    
     
}

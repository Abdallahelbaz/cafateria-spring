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

    

    @ManyToOne
    @JoinColumn(name = "technician_id", referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "tache_id", referencedColumnName = "id")
    private User user;

    @Column(name = "orderDate")
    private Date orderDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @Column(name = "status")
    private boolean status;
    
    
    
    
    
    public Order(Long id, Item item, User user, Date orderDate, Payment payment,boolean status) {
		super();
		this.id = id;
		this.item = item;
		this.user = user;
		this.orderDate = orderDate;
		this.payment = payment;
		this.status = status;
	}






	public boolean isStatus() {
		return status;
	}






	public void setStatus(boolean status) {
		this.status = status;
	}






	public Order() {
    }






	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public Item getItem() {
		return item;
	}






	public void setItem(Item item) {
		this.item = item;
	}






	public User getUser() {
		return user;
	}






	public void setUser(User user) {
		this.user = user;
	}






	public Date getOrderDate() {
		return orderDate;
	}






	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}






	public Payment getPayment() {
		return payment;
	}






	public void setPayment(Payment payment) {
		this.payment = payment;
	}

    

     

    
}

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
    private int id;

    @OneToMany
    private List<Item> items = new ArrayList<>();

    @OneToMany
    private List<Offer> offers = new ArrayList<>();

    @Column(name = "orderDate")
    private Date orderDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    
    
    
    
    
    public Order() {
    }

    

     

    public Order(List<Item> items, List<Offer> offers, Date orderDate, Payment payment) {
		super();
		this.items = items;
		this.offers = offers;
		this.orderDate = orderDate;
		this.payment = payment;
	}





	public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
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

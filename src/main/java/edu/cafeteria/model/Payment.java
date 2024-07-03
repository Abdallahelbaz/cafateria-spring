package edu.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "totalPrice")
    private float totalPrice;
   
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    
    
    
    public Payment() {
    }




	public Payment(Long id, float totalPrice, Order order, User user) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.order = order;
		this.user = user;
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

    

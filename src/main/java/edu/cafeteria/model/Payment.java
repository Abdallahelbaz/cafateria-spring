package edu.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "totalPrice")
    private float totalPrice;
    @Column(name = "payInCash")
    private boolean payInCash;

    public Payment() {
    }

    public Payment(float totalPrice, boolean payInCash) {
        this.totalPrice = totalPrice;
        this.payInCash = payInCash;
    }

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPayInCash() {
		return payInCash;
	}

	public void setPayInCash(boolean payInCash) {
		this.payInCash = payInCash;
	}

}

    

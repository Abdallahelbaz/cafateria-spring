package edu.abdullah.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "Payments")
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
        return totalPrice;}}

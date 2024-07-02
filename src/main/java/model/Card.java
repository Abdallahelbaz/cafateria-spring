package edu.abdullah.cafeteria.model;

import javax.persistence.*;
 


import java.util.Date;

@Entity
@Table(name = "Cards")
 
public class Card {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cardHolder")
    private String cardHolder;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "CVV")
    private int CVV;
    @Column(name = "expireDate")
    private String expireDate;
	public Card(  String cardHolder, String cardNumber, int cVV, String expireDate) {
		super();
		 
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		CVV = cVV;
		this.expireDate = expireDate;
	}
 
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

 

}

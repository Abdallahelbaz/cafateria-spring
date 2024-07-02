package edu.abdullah.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "Offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "offerName")
    private String offerName;
    @Column(name = "offerPrice")
    private float offerPrice;
	public Offer(String offerName, float offerPrice) {
		super();
		this.offerName = offerName;
		this.offerPrice = offerPrice;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public float getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(float offerPrice) {
		this.offerPrice = offerPrice;
	}
 
}


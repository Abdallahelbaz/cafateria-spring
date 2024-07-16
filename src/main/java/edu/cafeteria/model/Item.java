package edu.cafeteria.model;


import javax.persistence.*;
 

@Entity
@Table(name = "Item")
 
public   class Item {

    public Item() {
		 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

  

	@Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;
    
    @Column(name = "photoUrl")
    private String photoUrl;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
   public Item(  String name, String description, float price,String photoUrl) {
		super();
		 
		this.name = name;
		this.description = description;
		this.price = price;
		this.photoUrl = photoUrl;
	}

public Item(String name, String description, float price, String photoUrl, Order order) {
	super();
	this.name = name;
	this.description = description;
	this.price = price;
	this.photoUrl = photoUrl;
	this.order = order;
}

public String getPhotoUrl() {
	return photoUrl;
}

public void setPhotoUrl(String photoUrl) {
	this.photoUrl = photoUrl;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public Order getCart() {
	return order;
}

public void setCart(Order order) {
	this.order = order;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

}

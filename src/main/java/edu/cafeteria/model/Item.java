package edu.cafeteria.model;


import javax.persistence.*;
 

@Entity
@Table(name = "Item")
 
public abstract class Item {

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

   public Item(  String name, String description, float price) {
		super();
		 
		this.name = name;
		this.description = description;
		this.price = price;
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

}

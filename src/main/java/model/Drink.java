package edu.abdullah.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "Drinks")
public class Drink   {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_item", referencedColumnName = "id")
     
    private Item item;


	public Drink(  Item item) {
		super();
		 
		this.item = item;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
    
}


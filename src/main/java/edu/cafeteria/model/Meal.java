package edu.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "Meals")
public class Meal   {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id_item", referencedColumnName = "id")
	     
	    private Item item;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id_ingredients", referencedColumnName = "id")
	     
	    private Ingredient  ingredients;

	public Meal( Item item) {
		super();
		 
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	 
	 
	 
}

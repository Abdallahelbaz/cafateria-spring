package edu.abdullah.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ingredientName")
    private String ingredientName;

	public Ingredient(  String ingredientName) {
		super();
	 
		this.ingredientName = ingredientName;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

    
}

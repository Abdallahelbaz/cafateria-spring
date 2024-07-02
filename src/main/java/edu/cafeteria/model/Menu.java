package edu.cafeteria.model;


import javax.persistence.*;
 

import java.util.List;

@Entity
@Table(name = "Menus")
 
public class Menu {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

	 @Column(name = "title")
	    private String title;
	 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Menu(  String title, String image, List<Item> items) {
		super();
		 
		this.title = title;
		this.image = image;
		this.items = items;
	}

	@Column(name = "image")
	    private String image;

	    @OneToMany
	    private List<Item> items;

 

}


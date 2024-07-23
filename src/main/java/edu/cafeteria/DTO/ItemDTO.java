package edu.cafeteria.DTO;

import edu.cafeteria.model.Order;

public class ItemDTO {
	 private Long id;

	  

		 
	    private String name;
 
	    private String description;
 
	    private float price;
	     
	    private String photoUrl; 
	    private Order order;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getPhotoUrl() {
			return photoUrl;
		}
		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		public ItemDTO(Long id, String name, String description, float price, String photoUrl, Order order) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.photoUrl = photoUrl;
			this.order = order;
		}
		public ItemDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
}

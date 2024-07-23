package edu.cafeteria.DTO;

import edu.cafeteria.model.User;

public class EmployeeDTO {
	 private Long id;
	   
	    private boolean active;
	    
	    private String shift;
	    

	    
	   
	     
	    private User user;





		public EmployeeDTO() {
			super();
			 
		}





		public EmployeeDTO(Long id, boolean active, String shift, User user) {
			super();
			this.id = id;
			this.active = active;
			this.shift = shift;
			this.user = user;
		}





		public Long getId() {
			return id;
		}





		public void setId(Long id) {
			this.id = id;
		}





		public boolean isActive() {
			return active;
		}





		public void setActive(boolean active) {
			this.active = active;
		}





		public String getShift() {
			return shift;
		}





		public void setShift(String shift) {
			this.shift = shift;
		}





		public User getUser() {
			return user;
		}





		public void setUser(User user) {
			this.user = user;
		}

	    
	    
	    
	    
}

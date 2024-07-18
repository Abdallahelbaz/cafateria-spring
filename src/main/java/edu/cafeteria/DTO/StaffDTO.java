package edu.cafeteria.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cafeteria.model.User;

public class StaffDTO {
	
	
	 private Long id;
	 
	  
   private int hospitalStaffId;
 
	     
	    private User user;


		public StaffDTO() {
			super();
			// TODO Auto-generated constructor stub
		}


		public StaffDTO(Long id, int hospitalStaffId, User user) {
			super();
			this.id = id;
			this.hospitalStaffId = hospitalStaffId;
			this.user = user;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public int getHospitalStaffId() {
			return hospitalStaffId;
		}


		public void setHospitalStaffId(int hospitalStaffId) {
			this.hospitalStaffId = hospitalStaffId;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}
	    
	    
	    
	    
}

package edu.cafeteria.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cafeteria.model.User;

public class GuestDTO {
	 private Long id;
	 
	    private String mail;
    
    
    private User user;


	public GuestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GuestDTO(Long id, String mail, User user) {
		super();
		this.id = id;
		this.mail = mail;
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
    
    
    
}

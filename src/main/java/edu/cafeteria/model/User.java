package edu.cafeteria.model;

import javax.persistence.*;
import javax.transaction.Transactional;
 

import java.util.Date;
import java.util.List;


@Entity
 
 
@Table(name = "Users")
public   class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "birth_date")
    private Date birthDate;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "user_name",unique = true)
    private String userName;
    
    @Column(name = "user_password")
    private String password;
    
    @Column(name = "phone")
    private String phone;

    
    
    
    
    
    
    
    
    
    
    
    
	public User( String firstName, String lastName, Date birthDate, String email, String userName,
			String password, String phone) {
		super();
	 
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}

	 

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

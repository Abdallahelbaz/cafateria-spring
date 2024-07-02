package edu.cafeteria.model;

import javax.persistence.*;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee   {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "active") 
    private boolean active;
    @Column(name = "shift") 
    private String shift;
    @Column(name = "salary") 
    private float salary;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
     
    private User user;

    
    
    
    
    
    public Employee() {
    }






	public Employee(  boolean active, String shift, float salary, User user) {
		super();
		 
		this.active = active;
		this.shift = shift;
		this.salary = salary;
		this.user = user;
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






	public float getSalary() {
		return salary;
	}






	public void setSalary(float salary) {
		this.salary = salary;
	}






	public User getUser() {
		return user;
	}






	public void setUser(User user) {
		this.user = user;
	}

    
   
}

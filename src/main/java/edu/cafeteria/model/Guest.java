package edu.cafeteria.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Guests")
public class Guest   {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	 @Column(name = "mail") 
	    private String mail;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
     
    private Employee employee;
    
    
    
    
    public Guest() {
    }

    
    


	 



	public String getMail() {
		return mail;
	}





	public void setMail(String mail) {
		this.mail = mail;
	}





	public Guest(  String mail, Employee employee) {
		super();
		 
		this.mail = mail;
		this.employee = employee;
	}





	 


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}

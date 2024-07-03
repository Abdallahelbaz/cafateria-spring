package edu.cafeteria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Staffs")
public class Staff   {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	 
	 
	 
    @Column(name = "hospitalStaffId")
    private int hospitalStaffId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
	  
    public Staff() {
    }

    

     
    public int getHospitalStaffId() {
        return hospitalStaffId;
    }

    public void setHospitalStaffId(int hospitalStaffId) {
        this.hospitalStaffId = hospitalStaffId;
    }
}

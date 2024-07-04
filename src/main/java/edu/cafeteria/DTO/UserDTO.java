package edu.cafeteria.DTO;
 

import java.util.Date;

import javax.persistence.Column;

import edu.cafeteria.model.EmployeeID;
import edu.cafeteria.model.Role;
import edu.cafeteria.model.StaffID;

public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String userName;
    private String phone;
    private Role role;
    
    private StaffID staffID; 
    private EmployeeID employeeID; 
    
    
    
    private String password;
    
    

    public UserDTO() {}

    

    public StaffID getStaffID() {
		return staffID;
	}



	public void setStaffID(StaffID staffID) {
		this.staffID = staffID;
	}



	public EmployeeID getEmployeeID() {
		return employeeID;
	}



	public void setEmployeeID(EmployeeID employeeID) {
		this.employeeID = employeeID;
	}



	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	public UserDTO(Long id, String firstName, String lastName, Date birthDate, String email, String userName,
			String phone, String password, Role role, EmployeeID employeeID, StaffID staffID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.userName = userName;
		this.phone = phone;
		this.role = role;
		this.staffID = staffID;
		this.employeeID = employeeID;
		this.password = password;
	}

 


 

	 
}

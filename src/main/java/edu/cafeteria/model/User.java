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
    private Long id;
    
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

    
    public String roleS;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "employeeID")
    private EmployeeID employeeID;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "staffID")
    private StaffID staffID;
    
    
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;
	 

	 

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public User(String firstName, String lastName, Date birthDate, String email, String userName, String password,
			String phone, String roleS, Role role, EmployeeID employeeID, StaffID staffID, Cart cart) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.roleS = roleS;
		this.role = role;
		this.employeeID = employeeID;
		this.staffID = staffID;
		this.cart = cart;
	}


	public User(  String firstName, String lastName, Date birthDate, String email, String userName,
			String password, String phone, Role role, EmployeeID employeeID, StaffID staffID) {
		super();
		 
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.employeeID = employeeID;
		this.staffID = staffID;
		this.roleS=role.name();
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


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
	public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



	public EmployeeID getEmployeeID() {
		return employeeID;
	}



	public void setEmployeeID(EmployeeID employeeID) {
		this.employeeID = employeeID;
	}



	public StaffID getStaffID() {
		return staffID;
	}



	public void setStaffID(StaffID staffID) {
		this.staffID = staffID;
	}


	public String toStringImp() {
		String s= " userName:"+this.getUserName()+" email:"+this.getEmail() ;
		return null;
	}



	 



	 
    
}

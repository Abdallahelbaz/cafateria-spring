package edu.cafeteria.model;
 

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "timestamp")
    private Date timestamp;
    
    @Column(name = "user")
    private String user;
    
    @Column(name = "action")
    private String action;
    
    @Column(name = "role")
    private String role;

    public Log() {
    }

    public Log(Date timestamp, String user, String action,String role) {
        this.timestamp = timestamp;
        this.user = user;
        this.action = action;
        this.role = role;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
 
}

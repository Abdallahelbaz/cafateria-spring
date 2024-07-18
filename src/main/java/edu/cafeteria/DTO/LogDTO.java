package edu.cafeteria.DTO;

import java.util.Date;

import javax.persistence.Column;

public class LogDTO {
	  private Long id;
	     
	    private Date timestamp;
	     
	    private String user;
	     
	    private String action;
	     
	    private String role;

		public LogDTO(Long id, Date timestamp, String user, String action, String role) {
			super();
			this.id = id;
			this.timestamp = timestamp;
			this.user = user;
			this.action = action;
			this.role = role;
		}

		public LogDTO() {
			super();
			// TODO Auto-generated constructor stub
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

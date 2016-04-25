package com.neu.qask.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person {

	@Column(name="userName")
	    private String userName;
		
		@Column(name="password")
	    private String password;
		
		@Column(name="email")
	    private String email;
		

	    public User(String userName, String password , String email) {
	        this.userName = userName;
	        this.password = password;
	        this.email = email;
	    }

	    User() {
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}    
}

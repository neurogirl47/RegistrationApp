package com.eintrn.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="regdata")
public class User {
	@Id
	private int userId;
	
	@Column (name="usernm")
	private String username;
	
	@Column (name="passwd")
	private String password;
	
	@Column (name="passconf")
	private String passconf;
	
	@Column (name="email")
	private String email;
	
	@Column (name="dob")
	private String dob;
	
	@Column (name="gender")
	private String gender;

	public User(int userId, String username, String password, String passconf, String email,
			String dob, String gender) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.passconf = passconf;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		
	}
	
	public User(){
		username = null;
		password = null;
		passconf = null;
		email = null;
		dob = null;
		gender = null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassconf() {
		return passconf;
	}

	public void setPassconf(String passconf) {
		this.passconf = passconf;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

package com.modestack.assignment.apiassignment.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;
import com.modestack.assignment.apiassignment.article.Article;

//User Registration Class
@Entity
public class User {
	
	@Id
	private String username;
	
	private String password;

	private String email;
	
	private String address;	

	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User(String username, String password, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + "]";
	}
	

}

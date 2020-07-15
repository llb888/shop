package com.ghyy.domain;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport {
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;

	public User user;

	public User(User user) {
		this.user = user;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phone="
				+ phone + "]";
	}

	public String execute() {

		return Action.SUCCESS;
	}

}

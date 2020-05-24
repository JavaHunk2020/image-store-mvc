package com.rab3.controller.vo;

import java.sql.Timestamp;

/**
 * 
 * @author nagendra
 *
 */
public class ProfileDTO {
	private int aid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String gender;
	private String image;
	private Timestamp doe;
	private String role;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProfileDTO [aid=" + aid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", gender=" + gender + ", image=" + image + "]";
	}

}

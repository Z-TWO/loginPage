package com.loginPage.model;

public class User {
	private String username;
	private String password;
	private String teleNum;
	private String emial;
	
	//¹¹Ôìº¯Êý
	public User(String username, String password, String teleNum, String email) {
		this.username = username;
		this.password = password;
		this.teleNum = teleNum;
		this.emial = email;
	}

	//get and set
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

	public String getTeleNum() {
		return teleNum;
	}

	public void setTeleNum(String teleNum) {
		this.teleNum = teleNum;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}
	
}

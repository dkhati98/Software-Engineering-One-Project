package com.sred.eatright;

public class Account {
	
	private String userName;
	private String password;
	private Profile profile;
	
	Account (String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	private void setUserName(String userName) {
		this.userName = userName;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Profile getProfile() {
		return profile;
	}
}

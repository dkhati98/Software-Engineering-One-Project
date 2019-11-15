package com.sred.eatright;

public class Account {
	
	private String userName;
	private String password;
	private Profile profile;
	private Log log;
	
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

	public void setProfile(Profile profile) {
		this.profile = profile;
		log = new Log(profile);
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

	public Log getLog() {
		return log;
	}
}

//package com.sred.eatright.userInfo;
//
//import com.sred.eatright.Log;
//
///**
// * An account has a userName, a password, a profile and a log
// */
//public class Account {
//
//	private String userName;
//	private String password;
//	private Profile profile;
//	private Log log;
//
//	/**
//	 *This class holds the user's user name and password
//	 * @param userName
//	 * @param password
//	 */
//	Account (String userName, String password) {
//		this.userName = userName;
//		this.password = password;
//	}
//
//	/**
//	 * set the userName
//	 * @param userName
//	 */
//	private void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	/**
//	 * set password
//	 * @param password
//	 */
//	private void setPassword(String password) {
//		this.password = password;
//	}
//
//	/**
//	 * set user's profile and create a new log
//	 * @param profile
//	 */
//	public void setProfile(Profile profile) {
//		this.profile = profile;
//		log = new Log(profile);
//	}
//
//	/**
//	 * get the userName
//	 * @return a String of userName
//	 */
//	public String getUserName() {
//		return userName;
//	}
//
//	/**
//	 * get the password
//	 * @return a String of password
//	 */
//	public String getPassword() {
//		return password;
//	}
//
//	/**
//	 * get the profile
//	 * @return a Profile object
//	 */
//	public Profile getProfile() {
//		return profile;
//	}
//
//	/**
//	 * get the log
//	 * @return a Log object
//	 */
//	public Log getLog() {
//		return log;
//	}
//}

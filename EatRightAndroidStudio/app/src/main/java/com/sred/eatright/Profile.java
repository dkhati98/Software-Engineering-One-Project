package com.sred.eatright;

public class Profile {
	
	private String firstName;
	private String lastName;
	private	int age;
	private Gender gender;
	private int height;
	private String location;
	private int zip;
	private String timeZone;
	private	String emailAddress;
	private Goal goal;
	
	private Profile(ProfileBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.gender = builder.gender;
		this.height = builder.height;
		this.location = builder.location;
		this.zip = builder.zip;
		this.timeZone = builder.timeZone;
		this.emailAddress = builder.emailAddress;
		this.goal = builder.goal;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public Gender getGender() {
		return gender;
	}
	public int getHeight() {
		return height;
	}
	public String getLocation() {
		return location;
	}
	public int getZip() {
		return zip;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public String setEmialAddress() {
		return emailAddress;
	}
	public Goal setGoal() {
		return goal;
	}
	
	public static class ProfileBuilder {
		private String firstName;
		private String lastName;
		private int age;
		private Gender gender;
		private int height;
		private String location;
		private int zip;
		private String timeZone;
		private	String emailAddress;
		private Goal goal;
		
		public ProfileBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public ProfileBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public ProfileBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		public ProfileBuilder setGender(Gender gender) {
			this.gender = gender;
			return this;
		}
		public ProfileBuilder setHeight(int height) {
			this.height = height;
			return this;
		}
		public ProfileBuilder setLocation(String location) {
			this.location = location;
			return this;
		}
		public ProfileBuilder setZip(int zip) {
			this.zip = zip;
			return this;
		}
		public ProfileBuilder setTimeZone(String timeZone) {
			this.timeZone = timeZone;
			return this;
		}
		public ProfileBuilder setEmialAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}
		public ProfileBuilder setGoal(Goal goal) {
			this.goal = goal;
			return this;
		}
		public Profile buildProfile() {
			if (firstName == null || lastName == null) {
				throw new IllegalArgumentException("Required Fields Are Not Set");
			}
			return new Profile(this);
		}
	}

}

package com.sred.eatright.userInfo;

import com.sred.eatright.userInfo.helperClass.Gender;
import com.sred.eatright.userInfo.helperClass.Goal;

public class Profile {
	
	private final String firstName;
	private final String lastName;
	private	int age;
	private Gender gender;
	private int height;
	private String location;
	private int zip;
	private String timeZone;
	private	String emailAddress;
	private Goal goal;
	
	private Profile(String firstName, String lastName, int age, Gender gender, int height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.height = height;
	}

	//setter
	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	//call this function when the user gives all the information to create an object of Goal
	//well call this function again when the user finish filling data for NutritionGoal
	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	//getter
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

	public String getEmialAddress() {
		return emailAddress;
	}

	public Goal getGoal() {
		return goal;
	}


	//Builder functions
//	public static class ProfileBuilder {
//		private String firstName;
//		private String lastName;
//		private int age;
//		private Gender gender;
//		private int height;
//		private String location;
//		private int zip;
//		private String timeZone;
//		private	String emailAddress;
//		private Goal goal;
//
//		public ProfileBuilder setFirstName(String firstName) {
//			this.firstName = firstName;
//			return this;
//		}
//		public ProfileBuilder setLastName(String lastName) {
//			this.lastName = lastName;
//			return this;
//		}
//		public ProfileBuilder setAge(int age) {
//			this.age = age;
//			return this;
//		}
//		public ProfileBuilder setGender(Gender gender) {
//			this.gender = gender;
//			return this;
//		}
//		public ProfileBuilder setHeight(int height) {
//			this.height = height;
//			return this;
//		}
//		public ProfileBuilder setLocation(String location) {
//			this.location = location;
//			return this;
//		}
//		public ProfileBuilder setZip(int zip) {
//			this.zip = zip;
//			return this;
//		}
//		public ProfileBuilder setTimeZone(String timeZone) {
//			this.timeZone = timeZone;
//			return this;
//		}
//		public ProfileBuilder setEmialAddress(String emailAddress) {
//			this.emailAddress = emailAddress;
//			return this;
//		}
//		public ProfileBuilder setGoal(double curWeight, double goalWeight, FitnessGoal fitnessGoal, ActivityLevelActivity activityLevel, NutritionGoal nutritionGoal) {
//			Goal goal = new Goal.GoalBuilder().setCurWeight(curWeight)
//											.setGoalWeight(goalWeight)
//											.setFitnessGoal(fitnessGoal)
//											.setActivityLevel(activityLevel)
//											.setNutritionGoal(nutritionGoal)
//											.buildGoal();
//			this.goal = goal;
//			return this;
//		}
//		public Profile buildProfile() {
//			if (firstName == null || lastName == null) {
//				throw new IllegalArgumentException("Required Fields Are Not Set");
//			}
//			return new Profile(this);
//		}
//	}

}

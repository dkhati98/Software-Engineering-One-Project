//package com.sred.eatright.userInfo.helperClass;
//
//import com.sred.eatright.userInfo.ActivityLevelActivity;
//
//public class Goal {
//	private double curWeight;
//	private double goalWeight;
//	private FitnessGoal fitnessGoal;
//	private ActivityLevelActivity activityLevel;
//	private NutritionGoal nutritionGoal;
//
//	private Goal(double curWeight, double goalWeight, FitnessGoal fitnessGoal, ActivityLevelActivity activityLevel) {
//		this.curWeight = curWeight;
//		this.goalWeight = goalWeight;
//		this.fitnessGoal = fitnessGoal ;
//		this.activityLevel = activityLevel;
//	}
//
//	//setter
//	public void setCurWeight(double curWeight) {
//		this.curWeight = curWeight;
//	}
//
//	public void setGoalWeight(double goalWeight) {
//		this.goalWeight = goalWeight;
//	}
//
//	public void setActivityLevel(ActivityLevelActivity activityLevel) {
//		this.activityLevel = activityLevel;
//	}
//
//	public void setFitnessGoal(FitnessGoal fitnessGoal) {
//		this.fitnessGoal = fitnessGoal;
//	}
//
//	//call this function when the user gives all the information to create an object of NutritionGoal
//	public void setNutritionGoal(NutritionGoal nutritionGoal) {
//		this.nutritionGoal = nutritionGoal;
//	}
//
//	//getter
//
//	public double getCurWeight() {
//		return curWeight;
//	}
//
//	public double getGoalWeight() {
//		return goalWeight;
//	}
//
//	public FitnessGoal getFitnessGoal() {
//		return fitnessGoal;
//	}
//
//	public ActivityLevelActivity getActivityLevel() {
//		return activityLevel;
//	}
//
//	public NutritionGoal getNutrionGoal() {
//		return nutritionGoal;
//	}
//
//
////	Builder functions
//	public static class GoalBuilder {
//		private double curWeight;
//		private double goalWeight;
//		private FitnessGoal fitnessGoal;
//		private ActivityLevelActivity activityLevel;
//		private NutritionGoal nutritionGoal;
//
//		public GoalBuilder setCurWeight(double curWeight) {
//			this.curWeight = curWeight;
//			return this;
//		}
//		public GoalBuilder setGoalWeight(double goalWeight) {
//			this.goalWeight = goalWeight;
//			return this;
//		}
//		public GoalBuilder setFitnessGoal(FitnessGoal fitnessGoal) {
//			this.fitnessGoal = fitnessGoal;
//			return this;
//		}
//		public GoalBuilder setActivityLevel(ActivityLevelActivity activityLevel) {
//			this.activityLevel = activityLevel;
//			return this;
//		}
//		public GoalBuilder setNutritionGoal(NutritionGoal nutritionGoal) {
//			this.nutritionGoal = nutritionGoal;
//			return this;
//		}
//		public Goal buildGoal() {
//			return new Goal(this);
//		}
//	}
//}

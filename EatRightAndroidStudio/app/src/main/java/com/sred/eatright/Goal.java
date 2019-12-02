package com.sred.eatright;

public class Goal {
	
	private double curWeight;
	private double goalWeight;
	private FitnessGoal fitnessGoal;
	private ActivityLevel activityLevel;
	private NutritionGoal nutritionGoal;
	
	private Goal(GoalBuilder builder) {
		this.curWeight = builder.curWeight;
		this.goalWeight = builder.goalWeight;
		this.fitnessGoal = builder.fitnessGoal ;
		this.activityLevel = builder.activityLevel;
		this.nutritionGoal = builder.nutritionGoal;
	}
	
	public double getCurWeight() {
		return curWeight;
	}
	public double getGoalWeight() {
		return goalWeight;
	}
	public FitnessGoal getFitnessGoal() {
		return fitnessGoal;
	}
	public ActivityLevel getActivityLevel() {
		return activityLevel;
	}
	public NutritionGoal getNutrionGoal() {
		return nutritionGoal;
	}
	
	
//	public static class GoalBuilder {
//		private double curWeight;
//		private double goalWeight;
//		private FitnessGoal fitnessGoal;
//		private ActivityLevel activityLevel;
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
//		public GoalBuilder setActivityLevel(ActivityLevel activityLevel) {
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
}

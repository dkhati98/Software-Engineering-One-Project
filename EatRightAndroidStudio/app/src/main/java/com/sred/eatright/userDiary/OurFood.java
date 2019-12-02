//package com.sred.eatright.userDiary;
//
//import com.sred.eatright.userInfo.helperClass.MetricServingUnit;
//
//public class OurFood {
//
//    private int ourFoodID;
//    private String ourFoodName;
//    private Nutrient nutrient;
//    private int calories;
//    private MetricServingUnit metricServingUnit; //1 gram
//    private double numOfServings;
//
//    //constructor for database
////    public OurFood(DB db_Food) {
////        this.ourFoodID = db_Food.get(food_id);
////        this.ourFoodName = db_Food.get(food_name);
////        this.nutrient = new Nutrient.NutrientBuilder()
////                                        .setProtein(db_Food.get(protein))
////                                        .setCarbohydrates(db_Food.get(carbohydrate))
////                                        .setFat(db_Food.get(fat));
////        this.calories = db_Food.get(calories);
////        this.metricServingUnit = db_Food.get(metric_serving_unit);
////        this.numOfServings = db_Food.get(number_of_units);
////    }
//    //constructor for user creation
//
//    public OurFood(int ourFoodID, String ourFoodName, Nutrient nutrient, int calories, MetricServingUnit metricServingUnit, double numOfServings) {
//        this.ourFoodID = ourFoodID;
//        this.ourFoodName = ourFoodName;
//        this.nutrient = nutrient;
//        this.calories = calories;
//        this.metricServingUnit = metricServingUnit;
//        this.numOfServings = numOfServings;
//    }
//    //updating basic food information
////    public void setOurFoodID(int ourFoodID) {
////        this.ourFoodID = ourFoodID;
////    }
//    public void setOurFoodName(String ourFoodName) {
//        this.ourFoodName = ourFoodName;
//    }
//    private void updateNutrient(double protein, double carbohydrates, double fat) {
//        this.nutrient.setProtein(protein);
//        this.nutrient.setCarbohydrates(carbohydrates);
//        this.nutrient.setFat(fat);
//    }
//    private void updateCalories(double protein, double carbohydrates, double fat) {
//        this.calories = (int)(protein * 4 + carbohydrates * 4 + fat * 9);
//    }
//
//    public void updateNumOfServings(double newNumOfServings) {
//        //get the original number of servings
//        double prevNumOfServings = getNumOfServings();
//        //Protein
//        double ratioProtein = getRatio(this.nutrient.getProtein(), prevNumOfServings);//get how much protein per serving for the food
//        double updatedAmountOfProtein = getAmountNutrient(ratioProtein, newNumOfServings);//get the amount of protein the food contain after updating the number of servings
//        //Carbohydrates
//        double ratioCarbohydrates = getRatio(this.nutrient.getCarbohydrates(), prevNumOfServings);
//        double updatedAmountOfCarbohydrates = getAmountNutrient(ratioCarbohydrates, newNumOfServings);
//        //Fat
//        double ratioFat = getRatio(this.nutrient.getFat(), prevNumOfServings);
//        double updateAmountOfFat = getAmountNutrient(ratioFat, newNumOfServings);
//        //set updated data for nutrient
//        updateNutrient(updatedAmountOfProtein, updatedAmountOfCarbohydrates, updateAmountOfFat);
//        //set updated data for calories
//        updateCalories(updatedAmountOfProtein, updatedAmountOfCarbohydrates, updateAmountOfFat);
//        this.numOfServings = newNumOfServings; //set the new number of servings
//    }
//    //get how much nutrient per serving for the food
//    private double getRatio(double amountOfNutrient, double prevNumOfServings) {
//        return amountOfNutrient / prevNumOfServings;
//    }
//    //get the amount of nutrient the food contain after updating the number of servings
//    private double getAmountNutrient(double ratioNutrient, double newNumOfServings) {
//        return ratioNutrient * newNumOfServings;
//    }
//
//    public void updateServingSize(MetricServingUnit newMetricServingUnit) {
//        //get the previous serving unit
//        MetricServingUnit prevMetricServingUnit = getMetricServingUnit();
//        //newMetricServingUnit / prevMetricServingUnit
//        double ratioUnit = unitConverter(prevMetricServingUnit, newMetricServingUnit);
//
//        double protein = ratioUnit * this.nutrient.getProtein();
//        double carbohydrates = ratioUnit * this.nutrient.getCarbohydrates();
//        double fat = ratioUnit * this.nutrient.getFat();
//        //set updated data for calories
//        updateCalories(protein, carbohydrates, fat);
//        //set updated data for nutrient
//        updateNutrient(protein, carbohydrates, fat);
//        this.metricServingUnit = newMetricServingUnit;
//    }
//    //return the ratio of new unit and gram
//    private double unitConverter(MetricServingUnit metricServingUnit, MetricServingUnit newMetricServingUnit) {
//        switch (metricServingUnit) {
//            case GRAM:
//                switch (newMetricServingUnit) {
//                    case GRAM:
//                        return 1;
//                    case OUNCE:
//                        return 0.0353;
//                    case POUND:
//                        return 0.0022;
//                }
//            case OUNCE:
//                switch (newMetricServingUnit) {
//                    case GRAM:
//                        return 28.35;
//                    case OUNCE:
//                        return 1;
//                    case POUND:
//                        return 0.0625;
//                }
//                return 28.35;
//            case POUND:
//                switch (newMetricServingUnit) {
//                    case GRAM:
//                        return 453.592;
//                    case OUNCE:
//                        return 16;
//                    case POUND:
//                        return 1;
//                }
//                return 453.592;
//            default:
//                throw new IllegalArgumentException("Invalid Unit");
//        }
//    }
//
//    //getter
//    public int getOurFoodID() {
//        return ourFoodID;
//    }
//    public String getOurFoodName() {
//        return ourFoodName;
//    }
//    public Nutrient getNutrient() {
//        return nutrient;
//    }
//    public int getCalories() {
//        return calories;
//    }
//    public double getNumOfServings() {
//        return numOfServings;
//    }
//    public MetricServingUnit getMetricServingUnit() {
//        return metricServingUnit;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//       if (this == obj) {
//           return true;
//       }
//       if (!(obj instanceof OurFood)) {
//            return false;
//       }
//       OurFood ourFood = (OurFood) obj;
//       return this.ourFoodID == ourFood.ourFoodID &&
//               this.ourFoodName.equals(ourFood.ourFoodName) &&
//               this.nutrient.equals(ourFood.nutrient) &&
//               this.calories == ourFood.calories &&
//               this.metricServingUnit == ourFood.metricServingUnit &&
//               this.numOfServings == ourFood.numOfServings;
//    }
//
//    @Override
//    public int hashCode() {
//        return this.ourFoodID * 31 +
//                this.ourFoodName.hashCode() * 31 * 31 +
//                this.nutrient.hashCode() * 31 * 31 * 31 +
//                this.calories * 31 * 31 * 31 * 31 +
//                this.metricServingUnit.hashCode() * 31 * 31 * 31 * 31 * 31 +
//                (int)Double.doubleToLongBits(this.numOfServings) * 31 * 31 * 31 * 31 * 31 * 31;
//    }
//}

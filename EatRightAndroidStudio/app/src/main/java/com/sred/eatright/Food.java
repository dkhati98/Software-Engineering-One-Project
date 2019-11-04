package com.sred.eatright;

import androidx.annotation.Nullable;

public class OurFood {
    private int ourFoodID;
    private String ourFoodName;

    private Nutrient nutrient;
    private int calories;
    private MetricServingUnit metricServingUnit; //1 gram
    private double numOfServings;

    //constructor for database
    public OurFood(DB db_Food) {
        this.ourFoodID = db_Food.get(food_id);
        this.ourFoodName = db_Food.get(food_name);
        this.nutrient = new Nutrient.NutrientBuilder()
                                        .setProtein(db_Food.get(protein))
                                        .setCarbonHydrates(db_Food.get(carbonhydrate))
                                        .setFat(db_Food.get(fat));
        this.calories = db_Food.get(calories);
        this.metricServingUnit = db_Food.get(metric_serving_unit);
        this.numOfServings = db_Food.get(number_of_units);

    }
    //constructor for user creation
    public OurFood(int ourFoodID, String ourFoodName, Nutrient nutrient, int calories, MetricServingUnit metricServingUnit, double numOfServings) {
        this.ourFoodID = ourFoodID;
        this.ourFoodName = ourFoodName;
        this.nutrient = nutrient;
        this.calories = calories;
        this.metricServingUnit = metricServingUnit;
        this.numOfServings = numOfServings;
    }
    //updating basic food information

//    public void setOurFoodID(int ourFoodID) {
//        this.ourFoodID = ourFoodID;
//    }
//    public void setOurFoodName(String ourFoodName) {
//        this.ourFoodName = ourFoodName;
//    }
    private void updateNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }
    private void updateCalories(int calories) {
        this.calories = calories;
    }
    public void updateNumOfServings(double numOfServings) {

        //need to call conversion api
        //get uniformed data
        //convert data according to the corresponding unit
        //reassign the data

        double prevNumOfServings = getNumOfServings();
        MetricServingUnit prevMetricServingUnit = getMetricServingUnit();

        double ratio = prevNumOfServings /



        Nutrient nutrient = this.nutrient.setProtein();
        this.numOfServings = numOfServings;
        updateCalories();
        updateNutrient();
    }
    public void updateServingSize(MetricServingUnit metricServingUnit) {
        this.metricServingUnit = metricServingUnit;
        updateCalories();
        updateNutrient();
    }


    double amount  = numOfServings * servingSize;
    new Nutrient.NutrientBuilder()
            .setProtein(nutrient.getProtein())
            .setCarbonHydrates(nutrient.getCarbonHydrates())
            .setFat(nutrient.getFat())
            .build();

    //getter
    public int getOurFoodID() {
        return ourFoodID;
    }
    public String getOurFoodName() {
        return ourFoodName;
    }
    public Nutrient getNutrient() {
        return nutrient;
    }
    public int getCalories() {
        return calories;
    }
    public double getNumOfServings() {
        return numOfServings;
    }
    public MetricServingUnit getMetricServingUnit() {
        return metricServingUnit;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
       // return super.equals(obj);
    }
}

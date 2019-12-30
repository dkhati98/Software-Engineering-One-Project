//package com.sred.eatright.userDiary;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// */
//public class Meals{
//    private Nutrient overAllNutrients;
//    private int overAllCalories;
//    private List<OurFood> ourFoodList;
//
//    /**
//     *
//     */
//    Meals() {
//        this.ourFoodList = new ArrayList<>();
//        updateOverAllCalories();
//        updateOverAllNutrients();
//    }
//
//    private void updateOverAllNutrients() {
//        double overAllProtein = 0;
//        double overAllCarbohydrates = 0;
//        double overAllFat = 0;
//        if (ourFoodList != null || !ourFoodList.isEmpty()){
//            for(int i = 0; i < ourFoodList.size(); i++) {
//                //get each food's nutrient value
//                overAllProtein = overAllProtein + ourFoodList.get(i).getNutrient().getProtein();
//                overAllCarbohydrates = overAllCarbohydrates + ourFoodList.get(i).getNutrient().getCarbohydrates();
//                overAllFat = overAllFat + overAllCarbohydrates + ourFoodList.get(i).getNutrient().getFat();
//            }
//        }
//        this.overAllNutrients = new Nutrient.NutrientBuilder().setProtein(overAllProtein)
//                                                                .setCarbohydrates(overAllCarbohydrates)
//                                                                .setFat(overAllFat)
//                                                                .buildNutrient();
//    }
//    public void updateOverAllCalories() {
//        int overAllCalories = 0;
//        if (ourFoodList != null || !ourFoodList.isEmpty()){
//            for(int i = 0; i < ourFoodList.size(); i++) {
//                overAllCalories = overAllCalories + ourFoodList.get(i).getCalories();
//            }
//        }
//        this.overAllCalories = overAllCalories;
//    }
//
//    public Nutrient getOverAllNutrients() {
//        return overAllNutrients;
//    }
//    public int getOverAllCalories() {
//        return overAllCalories;
//    }
//
////    public List<OurFood> getOurFoodList() {
////        return ourFoodList;
////    }
//    //Will come back to check if we need to implement this function, when know how to manipulate data of an object in android
//    //If the view is directly connected with an ourFood object, we just update it when the user tap, so we won't need this function
////    public OurFood getOurFood(OurFood ourFood) {
////
////        return ourFood;
////    }
//    public void removeFood(OurFood ourFood) {
//        this.ourFoodList.remove(ourFood);//need to find which one needs to be removed
//        updateOverAllCalories();
//        updateOverAllNutrients();
//    }
//
//
//    public void addingFood(OurFood ourFood) {
//        this.ourFoodList.add(ourFood);
//        updateOverAllCalories();
//        updateOverAllNutrients();
//    }
//
//    //scanning food should be connected with fatsecrete api
//    public void scanningFood(OurFood food) {
//        this.ourFoodList.add(food);
//        updateOverAllCalories();
//        updateOverAllNutrients();
//    }
//}

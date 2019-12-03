
package com.sred.eatright.searchFood;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hint {

    @SerializedName("food")
    @Expose
    private Food_ food;
    @SerializedName("measures")
    @Expose
    private List<Measure> measures = null;

    public Food_ getFood() {
        return food;
    }

    public void setFood(Food_ food) {
        this.food = food;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

}

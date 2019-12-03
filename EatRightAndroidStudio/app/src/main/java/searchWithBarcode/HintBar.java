
package searchWithBarcode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HintBar {

    @SerializedName("food")
    @Expose
    private FoodBar food;
    @SerializedName("measures")
    @Expose
    private List<MeasureBar> measures = null;

    public FoodBar getFood() {
        return food;
    }

    public void setFood(FoodBar food) {
        this.food = food;
    }

    public List<MeasureBar> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasureBar> measures) {
        this.measures = measures;
    }

}

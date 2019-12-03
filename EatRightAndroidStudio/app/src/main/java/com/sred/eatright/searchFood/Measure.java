
package com.sred.eatright.searchFood;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Measure {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("qualified")
    @Expose
    private List<List<Qualified>> qualified = null;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<List<Qualified>> getQualified() {
        return qualified;
    }

    public void setQualified(List<List<Qualified>> qualified) {
        this.qualified = qualified;
    }

}

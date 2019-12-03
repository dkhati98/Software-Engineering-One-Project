
package com.sred.eatright.searchFood;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qualified {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;

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

}


package searchWithBarcode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BarcodeResult {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("parsed")
    @Expose
    private List<Object> parsed = null;
    @SerializedName("hints")
    @Expose
    private List<HintBar> hints = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Object> getParsed() {
        return parsed;
    }

    public void setParsed(List<Object> parsed) {
        this.parsed = parsed;
    }

    public List<HintBar> getHints() {
        return hints;
    }

    public void setHints(List<HintBar> hints) {
        this.hints = hints;
    }

}

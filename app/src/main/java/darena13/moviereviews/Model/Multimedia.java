package darena13.moviereviews.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darena13 on 08.08.2017.
 */

public class Multimedia {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("src")
    @Expose
    private String src;

    @SerializedName("width")
    @Expose
    private int swidth;

    @SerializedName("height")
    @Expose
    private int height;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getSwidth() {
        return swidth;
    }

    public void setSwidth(int swidth) {
        this.swidth = swidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

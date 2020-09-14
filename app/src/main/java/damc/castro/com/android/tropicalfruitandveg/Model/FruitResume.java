package damc.castro.com.android.tropicalfruitandveg.Model;

import com.google.gson.annotations.SerializedName;

public class FruitResume {

    @SerializedName("botname")
    private String botname;

    @SerializedName("imageurl")
    private String imageurl;

    @SerializedName("tfvname")
    private String tfvname;

    @SerializedName("othname")
    private String othname;

    public String getBotname() {
        return botname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getTfvname() {
        return tfvname;
    }

    public String getOthname() {
        return othname;
    }
}

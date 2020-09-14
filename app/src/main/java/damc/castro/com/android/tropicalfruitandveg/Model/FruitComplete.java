package damc.castro.com.android.tropicalfruitandveg.Model;

import com.google.gson.annotations.SerializedName;

public class FruitComplete {

    @SerializedName("botname")
    private String botname;

    @SerializedName("propagation")
    private String propagation;

    @SerializedName("imageurl")
    private String imageurl;

    @SerializedName("description")
    private String description;

    @SerializedName("health")
    private String health;

    @SerializedName("uses")
    private String uses;

    @SerializedName("soil")
    private String soil;

    @SerializedName("climate")
    private String climate;

    @SerializedName("tfvname")
    private String tfvname;

    @SerializedName("othname")
    private String othname;

    public String getBotname() {
        return botname;
    }

    public void setBotname(String botname) {
        this.botname = botname;
    }

    public String getPropagation() {
        return propagation;
    }

    public void setPropagation(String propagation) {
        this.propagation = propagation;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTfvname() {
        return tfvname;
    }

    public void setTfvname(String tfvname) {
        this.tfvname = tfvname;
    }

    public String getOthname() {
        return othname;
    }

    public void setOthname(String othname) {
        this.othname = othname;
    }
}

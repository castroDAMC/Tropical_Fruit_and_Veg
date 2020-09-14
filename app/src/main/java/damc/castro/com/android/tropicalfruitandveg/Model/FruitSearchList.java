package damc.castro.com.android.tropicalfruitandveg.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FruitSearchList {

    @SerializedName("tfvcount")
    private int tfvcount;

    @SerializedName("results")
    private List<FruitResume> results;

    public int getTfvcount() {
        return tfvcount;
    }

    public List<FruitResume> getResults() {
        return results;
    }
}

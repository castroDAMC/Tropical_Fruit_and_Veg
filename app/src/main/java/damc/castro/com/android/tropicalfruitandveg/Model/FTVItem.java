package damc.castro.com.android.tropicalfruitandveg.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FTVItem{

	@SerializedName("tfvcount")
	private int tfvcount;

	@SerializedName("results")
	private List<FruitComplete> results;

	public int getTfvcount() {
		return tfvcount;
	}

	public List<FruitComplete> getResults() {
		return results;
	}
}
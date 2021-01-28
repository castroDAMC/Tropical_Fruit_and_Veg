package damc.castro.com.android.tropicalfruitandveg.ModelTests;

import com.google.gson.Gson;

import org.junit.Test;

import damc.castro.com.android.tropicalfruitandveg.Model.FTVItem;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitSearchList;
import damc.castro.com.android.tropicalfruitandveg.Network.BaseRequest;
import damc.castro.com.android.tropicalfruitandveg.Network.KRequests;

public class SearchConverterTest {

    BaseRequest req = new KRequests();
    Gson gson = new Gson();

    @Test
    public void convertFruitComplete() {
        String input = req.makeRequest(BaseRequest.ITEM_DETAIL_REQUEST,"XX");
        FTVItem entity = gson.fromJson(input, FTVItem.class);
        System.out.println(entity);
    }

    @Test
    public void convertFruitSearch() {
        String input = req.makeRequest(BaseRequest.SEARCH_REQUEST,"BAN");
        FruitSearchList entity = gson.fromJson(input, FruitSearchList.class);
        System.out.println(entity);
    }
}

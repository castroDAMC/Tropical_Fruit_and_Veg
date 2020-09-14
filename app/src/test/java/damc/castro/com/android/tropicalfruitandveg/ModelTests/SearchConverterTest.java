package damc.castro.com.android.tropicalfruitandveg.ModelTests;

import com.google.gson.Gson;

import org.junit.Test;

import java.io.IOException;

import damc.castro.com.android.tropicalfruitandveg.Model.FTVItem;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitSearchList;
import damc.castro.com.android.tropicalfruitandveg.Network.Requests;

public class SearchConverterTest {

    Requests req = new Requests();
    Gson gson = new Gson();

    @Test
    public void convertFruitComplete() throws IOException, InterruptedException {
        String input = req.makeRequest(Requests.ITEM_DETAIL_REQUEST,"XX");
        FTVItem entity = gson.fromJson(input, FTVItem.class);
        System.out.println(entity);
    }

    @Test
    public void convertFruitSearch() throws IOException, InterruptedException {
        String input = req.makeRequest(Requests.SEARCH_REQUEST,"BAN");
        FruitSearchList entity = gson.fromJson(input, FruitSearchList.class);
        System.out.println(entity);
    }
}

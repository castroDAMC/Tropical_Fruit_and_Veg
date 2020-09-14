package damc.castro.com.android.tropicalfruitandveg.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

public class Requests {

    public static final String SEARCH_REQUEST = "search";
    public static final String ITEM_DETAIL_REQUEST = "tfvitem";

    public OkHttpClient client = new OkHttpClient();
    public String URL_BASE = "http://api.tropicalfruitandveg.com/tfvjsonapi.php?";

    public String makeRequest(final String TYPE_OF_REQUEST, final String parameter) throws IOException {

        Request req;

        req = new Request.Builder()
                .url(URL_BASE + TYPE_OF_REQUEST + "=" + parameter)
                .build();

        return client.newCall(req).execute().body().string();
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

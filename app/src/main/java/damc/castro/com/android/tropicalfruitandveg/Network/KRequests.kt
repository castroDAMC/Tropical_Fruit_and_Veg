package damc.castro.com.android.tropicalfruitandveg.Network

import android.content.Context
import android.net.ConnectivityManager
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.io.IOException

class KRequests : BaseRequest{

    companion object{
        val SEARCH_REQUEST = "search"
        val ITEM_DETAIL_REQUEST = "tfvitem"

        var client = OkHttpClient()
        var URL_BASE = "http://api.tropicalfruitandveg.com/tfvjsonapi.php?"
    }



    override fun makeRequest(TYPE_OF_REQUEST: String, parameter: String): String {
        val req: Request = Request.Builder()
                .url("$URL_BASE$TYPE_OF_REQUEST=$parameter")
                .build()
        return client.newCall(req).execute().body().string()
    }

    override fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
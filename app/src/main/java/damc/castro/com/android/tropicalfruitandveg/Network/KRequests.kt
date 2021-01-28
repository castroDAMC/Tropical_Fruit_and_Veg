package damc.castro.com.android.tropicalfruitandveg.Network

import android.content.Context
import android.net.ConnectivityManager
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request

class KRequests : BaseRequest{

    var client = OkHttpClient()

    override fun makeRequest(TYPE_OF_REQUEST: String, parameter: String): String {
        val req: Request = Request.Builder()
                .url(BaseRequest.URL_BASE + TYPE_OF_REQUEST + "=" + parameter)
                .build()
        return client.newCall(req).execute().body().string()
    }

    override fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
package damc.castro.com.android.tropicalfruitandveg.Network

import android.content.Context

interface BaseRequest {

    companion object{
        const val SEARCH_REQUEST = "search"
        const val ITEM_DETAIL_REQUEST = "tfvitem"
        const val URL_BASE = "http://api.tropicalfruitandveg.com/tfvjsonapi.php?"
    }

    fun makeRequest(TYPE_OF_REQUEST: String, parameter: String): String
    fun isNetworkAvailable(context: Context): Boolean
}
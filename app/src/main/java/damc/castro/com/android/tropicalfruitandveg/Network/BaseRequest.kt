package damc.castro.com.android.tropicalfruitandveg.Network

import android.content.Context

interface BaseRequest {

    fun makeRequest(TYPE_OF_REQUEST: String, parameter: String): String
    fun isNetworkAvailable(context: Context): Boolean
}
package damc.castro.com.android.tropicalfruitandveg.Controller

import android.os.AsyncTask
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import damc.castro.com.android.tropicalfruitandveg.Model.FruitSearchList
import damc.castro.com.android.tropicalfruitandveg.Network.Requests
import damc.castro.com.android.tropicalfruitandveg.View.MainActivity
import damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents.FruitListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*

class KMainActivityController() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var req: Requests
    private lateinit var mMain: MainActivity
    private lateinit var gson: Gson

    constructor(arg1: MainActivity) : this() {
        mMain = arg1
        req = Requests()
        gson = Gson()
        setRecyclerViewConfiguration()
        makeAndListFirstRequest()
        setSearchListener()
    }

    private fun makeAndListFirstRequest() {
        makeRequest(Requests.SEARCH_REQUEST, "")
    }

    private fun setSearchListener() {
        val btn = mMain!!.binding.BTNSearch
        btn.setOnClickListener { makeRequest(Requests.SEARCH_REQUEST, mMain!!.binding.TVSearchBox.text.toString()) }
    }

    private fun setRecyclerViewConfiguration() {
        recyclerView = mMain!!.binding.RVMainActivity
        recyclerView!!.adapter = FruitListAdapter(ArrayList())
        recyclerView!!.layoutManager = LinearLayoutManager(mMain)
    }

    fun makeRequest(typeOfRequest: String?, param: String) {
        if (!req!!.isNetworkAvailable(mMain)) {
            Toast.makeText(mMain, "Missing internet Connection, please try again when data is provided", Toast.LENGTH_LONG).show()
            return
        }
        var toBeSearch: String = param.trim { it <= ' ' }
        
        if (toBeSearch == "") {
            toBeSearch = "all"
        }
        val input = arrayOf("")
        val entity: Array<FruitSearchList?> = arrayOfNulls(1)
        val finalToBeSearch = toBeSearch

        GlobalScope.launch(Dispatchers.Main){
            try {
                input[0] = req!!.makeRequest(typeOfRequest, finalToBeSearch)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            if (input[0].contains("\"error\":\"No results found")) {
                Toast.makeText(mMain, "No results for $finalToBeSearch", Toast.LENGTH_LONG).show()
            } else {
                entity[0] = gson!!.fromJson(input[0], FruitSearchList::class.java)
                (recyclerView.adapter as FruitListAdapter).setFruitResumeList(entity[0]?.results)
//                (recyclerView.adapter as FruitListAdapter)!!.setFruitResumeList(entity[0]?.results)
            }
        }
    }
}
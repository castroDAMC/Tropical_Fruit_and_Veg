package damc.castro.com.android.tropicalfruitandveg.Controller

import android.os.AsyncTask
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import damc.castro.com.android.tropicalfruitandveg.Model.FTVItem
import damc.castro.com.android.tropicalfruitandveg.Model.FruitComplete
import damc.castro.com.android.tropicalfruitandveg.Network.Requests
import damc.castro.com.android.tropicalfruitandveg.View.MainActivity
import damc.castro.com.android.tropicalfruitandveg.View.MoreDetailsActivity
import damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents.FruitCompleteAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class KMoreDetailsActivityController() {

    private var req: Requests? = null
    private var mMain: MoreDetailsActivity? = null
    private var gson: Gson? = null
    private var fruitComplete: FruitComplete? = null
    private var recyclerView: RecyclerView? = null


    constructor(arg1: MoreDetailsActivity) : this() {
        this.mMain = arg1
        req = Requests()
        gson = Gson()
        makeRequest(Requests.ITEM_DETAIL_REQUEST, mMain!!.ftvitem)
    }

    fun KMoreDetailsActivityController(mMain: MoreDetailsActivity) {
        this.mMain = mMain
        req = Requests()
        gson = Gson()
        makeRequest(Requests.ITEM_DETAIL_REQUEST, mMain.ftvitem)
    }

    fun makeRequest(typeOfRequest: String?, toBeSearch: String) {
        if (!req!!.isNetworkAvailable(mMain)) {
            Toast.makeText(mMain, "Missing internet Connection, please try again when data is provided", Toast.LENGTH_LONG).show()
            return
        }
        val input = arrayOf("")
        val entity = arrayOfNulls<FTVItem>(1)

        GlobalScope.launch(Dispatchers.Main) {
            try {
                input[0] = req!!.makeRequest(typeOfRequest, toBeSearch)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            entity[0] = gson!!.fromJson(input[0], FTVItem::class.java)
            fruitComplete = entity[0]?.getResults()?.get(0)
            setRecyclerViewConfiguration()
            loadImage()
        }
    }

    private fun setRecyclerViewConfiguration() {
        recyclerView = mMain!!.binding.RVDetail
        recyclerView!!.adapter = FruitCompleteAdapter(fruitComplete)
        recyclerView!!.layoutManager = LinearLayoutManager(mMain)
    }

    fun loadImage() {
        val imageView = mMain!!.binding.IMVItemPhoto
        Glide.with(mMain!!).load(fruitComplete!!.imageurl).into(imageView)
    }

}
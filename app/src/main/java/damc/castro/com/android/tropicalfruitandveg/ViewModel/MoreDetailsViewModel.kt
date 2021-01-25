package damc.castro.com.android.tropicalfruitandveg.ViewModel

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import damc.castro.com.android.tropicalfruitandveg.Model.FTVItem
import damc.castro.com.android.tropicalfruitandveg.Model.FruitComplete
import damc.castro.com.android.tropicalfruitandveg.Network.KRequests
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoreDetailsViewModel {
    private var FTVItemList: MutableLiveData<FruitComplete> = MutableLiveData()
    private var req = KRequests()
    private var gson = Gson()

    fun getFruitLiveData(): MutableLiveData<FruitComplete> {
        return FTVItemList
    }

    fun getData(fruit: String) {
        val input = arrayOf("")
        val entity = arrayOfNulls<FTVItem>(1)

        GlobalScope.launch(Dispatchers.Default) {
            input[0] = req.makeRequest(KRequests.ITEM_DETAIL_REQUEST, fruit)

            entity[0] = gson.fromJson(input[0], FTVItem::class.java)
            FTVItemList.postValue(entity[0]!!.results[0])
        }
    }
}
package damc.castro.com.android.tropicalfruitandveg.ViewModel

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import damc.castro.com.android.tropicalfruitandveg.Model.FTVItem
import damc.castro.com.android.tropicalfruitandveg.Model.FruitComplete
import damc.castro.com.android.tropicalfruitandveg.Network.BaseRequest
import damc.castro.com.android.tropicalfruitandveg.Network.KRequests
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoreDetailsViewModel {
    private val completeItem: MutableLiveData<FruitComplete> = MutableLiveData()

    fun getFruitLiveData(): MutableLiveData<FruitComplete> {
        return completeItem
    }

    fun getData(fruit: String) {
        val input = arrayOf("")
        val entity = arrayOfNulls<FTVItem>(1)

        GlobalScope.launch(Dispatchers.Default) {
            input[0] = KRequests().makeRequest(BaseRequest.ITEM_DETAIL_REQUEST, fruit)
            entity[0] = Gson().fromJson(input[0], FTVItem::class.java)

            completeItem.postValue(entity[0]!!.results[0])
        }
    }
}
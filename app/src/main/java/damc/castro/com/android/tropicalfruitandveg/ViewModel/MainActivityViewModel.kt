package damc.castro.com.android.tropicalfruitandveg.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import damc.castro.com.android.tropicalfruitandveg.Model.FruitResume
import damc.castro.com.android.tropicalfruitandveg.Model.FruitSearchList
import damc.castro.com.android.tropicalfruitandveg.Network.BaseRequest
import damc.castro.com.android.tropicalfruitandveg.Network.KRequests
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

typealias mutable = MutableLiveData<List<FruitResume>>

class MainActivityViewModel : ViewModel() {
    private var fruitListLiveData : mutable = MutableLiveData()
    private var req: KRequests = KRequests()
    private var gson: Gson  = Gson()


    init {
        getData( "")
    }

    fun getFruitLiveData(): mutable{
        return fruitListLiveData
    }

    fun getData(param: String) {
        var toBeSearch: String = param.trim { it <= ' ' }

        if (toBeSearch == "") {
            toBeSearch = "all"
        }

        val input = arrayOf("")
        val entity: Array<FruitSearchList?> = arrayOfNulls(1)
        val finalToBeSearch = toBeSearch

        GlobalScope.launch(Dispatchers.Default){
            input[0] = req.makeRequest(BaseRequest.SEARCH_REQUEST, finalToBeSearch)

            if (input[0].contains("\"error\":\"No results found")) {
            } else {
                entity[0] = gson.fromJson(input[0], FruitSearchList::class.java)
                fruitListLiveData.postValue(entity[0]!!.results)
            }
        }
    }

}


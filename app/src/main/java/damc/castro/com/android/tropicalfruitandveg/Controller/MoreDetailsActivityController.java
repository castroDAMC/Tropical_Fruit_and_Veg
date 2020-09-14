package damc.castro.com.android.tropicalfruitandveg.Controller;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import damc.castro.com.android.tropicalfruitandveg.Model.FTVItem;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitComplete;
import damc.castro.com.android.tropicalfruitandveg.Network.Requests;
import damc.castro.com.android.tropicalfruitandveg.View.MoreDetailsActivity;
import damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents.FruitCompleteAdapter;

public class MoreDetailsActivityController {

    private Requests req;
    private MoreDetailsActivity mMain;
    private Gson gson;
    private FruitComplete fruitComplete;
    private RecyclerView recyclerView;

    public MoreDetailsActivityController(MoreDetailsActivity mMain){
        this.mMain = mMain;
        req = new Requests();
        gson = new Gson();
        makeRequest(Requests.ITEM_DETAIL_REQUEST, mMain.getFtvitem());
    }

    public void makeRequest(final String typeOfRequest, final String toBeSearch){

        if (! req.isNetworkAvailable(mMain)){
            Toast.makeText(mMain, "Missing internet Connection, please try again when data is provided", Toast.LENGTH_LONG).show();
            return;
        }

        final String[] input = {""};
        final FTVItem[] entity = new FTVItem[1];

        final String finalToBeSearch = toBeSearch;
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    input[0] = req.makeRequest(typeOfRequest, finalToBeSearch);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                entity[0] = gson.fromJson(input[0], FTVItem.class);
                fruitComplete = entity[0].getResults().get(0);
                setRecyclerViewConfiguration();
                loadImage();
            }
        }.execute();
    }

    private void setRecyclerViewConfiguration() {
        recyclerView = mMain.getBinding().RVDetail;
        recyclerView.setAdapter(new FruitCompleteAdapter(fruitComplete));
        recyclerView.setLayoutManager(new LinearLayoutManager(mMain));
    }

    public void loadImage(){
        ImageView imageView = mMain.getBinding().IMVItemPhoto;

        Glide.with(mMain).load(fruitComplete.getImageurl()).into(imageView);
    }
}

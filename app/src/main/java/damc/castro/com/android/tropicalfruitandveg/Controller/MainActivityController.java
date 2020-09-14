package damc.castro.com.android.tropicalfruitandveg.Controller;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitResume;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitSearchList;
import damc.castro.com.android.tropicalfruitandveg.Network.Requests;
import damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents.FruitListAdapter;
import damc.castro.com.android.tropicalfruitandveg.View.MainActivity;

public class MainActivityController {
    private RecyclerView recyclerView;
    private Requests req;
    private MainActivity mMain;
    private Gson gson;

    public MainActivityController(MainActivity main) throws IOException, InterruptedException {
        mMain = main;
        req = new Requests();
        gson = new Gson();
        setRecyclerViewConfiguration();
        makeAndListFirstRequest();
        setSearchListener();
    }

    private void makeAndListFirstRequest() {
        makeRequest(Requests.SEARCH_REQUEST, "");
    }

    private void setSearchListener(){
        Button btn = mMain.getBinding().BTNSearch;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest(Requests.SEARCH_REQUEST, mMain.getBinding().TVSearchBox.getText().toString());
            }
        });
    }

    private void setRecyclerViewConfiguration() {
        recyclerView = mMain.getBinding().RVMainActivity;
        recyclerView.setAdapter(new FruitListAdapter(new ArrayList<FruitResume>()));
        recyclerView.setLayoutManager(new LinearLayoutManager(mMain));
    }

    public void makeRequest(final String typeOfRequest, final String param){

        if (! req.isNetworkAvailable(mMain)){
            Toast.makeText(mMain, "Missing internet Connection, please try again when data is provided", Toast.LENGTH_LONG).show();
            return;
        }

        String toBeSearch = param.trim();
        if (toBeSearch.equals("")){
            toBeSearch = "all";
        }

        final String[] input = {""};
        final FruitSearchList[] entity = new FruitSearchList[1];

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

                if(input[0].contains("\"error\":\"No results found")){
                    Toast.makeText(mMain, "No results for " + finalToBeSearch, Toast.LENGTH_LONG).show();
                    return;
                }

                entity[0] = gson.fromJson(input[0], FruitSearchList.class);
                ((FruitListAdapter)recyclerView.getAdapter()).setFruitResumeList(entity[0].getResults());
            }
        }.execute();
    }

}


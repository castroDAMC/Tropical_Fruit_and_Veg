package damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitComplete;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitResume;
import damc.castro.com.android.tropicalfruitandveg.R;

public class FruitCompleteAdapter extends RecyclerView.Adapter {

    private final String TAG = this.getClass().getSimpleName();
    private List<String> fruitComplete = new ArrayList<>();

    public FruitCompleteAdapter(FruitComplete fruitComplete){
        setFruitResumeList(fruitComplete);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        int layoutForListItem = R.layout.recycler_activity;
        View view = inflater.inflate(layoutForListItem, parent, false);
        return new FruitCompleteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FruitCompleteHolder) holder).bind(fruitComplete.get(position));
    }

    @Override
    public int getItemCount() {
        return fruitComplete.size();
    }

    public void setFruitResumeList(FruitComplete fruitComplete) {

        if (fruitComplete != null){
            this.fruitComplete.add("Name : " + fruitComplete.getTfvname() + "\n");
            this.fruitComplete.add("Botanical Name : " + fruitComplete.getBotname()+ "\n");
            this.fruitComplete.add("Description : " + fruitComplete.getDescription()+ "\n");
            this.fruitComplete.add("Uses : " + fruitComplete.getUses()+ "\n");
            this.fruitComplete.add("Climate : " + fruitComplete.getClimate()+ "\n");
            this.fruitComplete.add("More Names : " + fruitComplete.getOthname()+ "\n");
            this.fruitComplete.add("Propagation : " + fruitComplete.getPropagation()+ "\n");
            this.fruitComplete.add("Health Information : " + fruitComplete.getHealth()+ "\n");
            this.fruitComplete.add("Soil Information : " + fruitComplete.getSoil()+ "\n");
        }
        notifyDataSetChanged();
    }

}

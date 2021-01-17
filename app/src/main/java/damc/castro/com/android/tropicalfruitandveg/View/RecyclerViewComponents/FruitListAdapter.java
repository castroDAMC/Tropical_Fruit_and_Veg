package damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import damc.castro.com.android.tropicalfruitandveg.Model.FruitResume;
import damc.castro.com.android.tropicalfruitandveg.R;

public class FruitListAdapter extends RecyclerView.Adapter {

    private final String TAG = this.getClass().getSimpleName();
    private List<FruitResume> fruitResumeList;

    public FruitListAdapter(Collection<FruitResume> fruitResume) {
        this.fruitResumeList = (ArrayList<FruitResume>) fruitResume;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        int layoutForListItem = R.layout.recycler_activity;
        View view = inflater.inflate(layoutForListItem, parent, false);
        return new FruitListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FruitListHolder) holder).bind(fruitResumeList.get(position).getTfvname());
    }

    @Override
    public int getItemCount() {
        return fruitResumeList.size();
    }

    public void setFruitResumeList(List<FruitResume> list) {

        this.fruitResumeList.clear();

        for (FruitResume fruitResume : list) {
            this.fruitResumeList.add(fruitResume);
        }

        notifyDataSetChanged();
    }
}

package damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import damc.castro.com.android.tropicalfruitandveg.R;

public class FruitCompleteHolder extends RecyclerView.ViewHolder {

    private TextView fruitName;
    private Context context;

    public FruitCompleteHolder(@NonNull View itemView) {
        super(itemView);
        fruitName = itemView.findViewById(R.id.TV_fruitName);
        context = itemView.getContext();
    }

    public void bind(final String ftvitem) {
        this.fruitName.setText(ftvitem);
    }
}

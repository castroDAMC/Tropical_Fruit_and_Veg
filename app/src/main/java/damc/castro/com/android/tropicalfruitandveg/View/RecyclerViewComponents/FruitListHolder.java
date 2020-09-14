package damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import damc.castro.com.android.tropicalfruitandveg.R;
import damc.castro.com.android.tropicalfruitandveg.View.MoreDetailsActivity;

public class FruitListHolder extends RecyclerView.ViewHolder {

    private TextView fruitName;
    private Context context;


    public FruitListHolder(@NonNull View itemView) {
        super(itemView);
        fruitName = itemView.findViewById(R.id.TV_fruitName);
        context = itemView.getContext();
    }

    public void bind(final String ftvitem) {

        this.fruitName.setText(ftvitem);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, MoreDetailsActivity.class);
                myIntent.putExtra("ftvitem", fruitName.getText().toString()); //Optional parameters
                context.startActivity(myIntent);
            }
        });
    }

}

package damc.castro.com.android.tropicalfruitandveg.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import damc.castro.com.android.tropicalfruitandveg.Model.FruitComplete;
import damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents.FruitCompleteAdapter;
import damc.castro.com.android.tropicalfruitandveg.ViewModel.MoreDetailsViewModel;
import damc.castro.com.android.tropicalfruitandveg.databinding.ActivityItemDetailBinding;

public class MoreDetailsActivity extends AppCompatActivity {

    private ActivityItemDetailBinding binding;
    private MoreDetailsViewModel VM;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityItemDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setRecyclerViewConfiguration();

        VM = new MoreDetailsViewModel();
        VM.getFruitLiveData().observe(this, new Observer<FruitComplete>() {
            @Override
            public void onChanged(FruitComplete fruitComplete) {
                ((FruitCompleteAdapter)recyclerView.getAdapter()).setFruitResumeList(fruitComplete);
                loadImage(fruitComplete.getImageurl());
            }
        });

        Intent intent = getIntent();
        String ftvitem = intent.getStringExtra("ftvitem");

        VM.getData(ftvitem);
    }

    private void setRecyclerViewConfiguration() {
        recyclerView = binding.RVDetail;
        recyclerView.setAdapter(new FruitCompleteAdapter(new FruitComplete()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void loadImage(String imageUrl){
        Glide.with(this).load(imageUrl).into(binding.IMVItemPhoto);
    }
}

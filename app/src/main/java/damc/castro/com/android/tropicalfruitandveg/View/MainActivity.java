package damc.castro.com.android.tropicalfruitandveg.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import damc.castro.com.android.tropicalfruitandveg.Model.FruitResume;
import damc.castro.com.android.tropicalfruitandveg.View.RecyclerViewComponents.FruitListAdapter;
import damc.castro.com.android.tropicalfruitandveg.ViewModel.MainActivityViewModel;
import damc.castro.com.android.tropicalfruitandveg.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private MainActivityViewModel VM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setRecyclerViewConfiguration();

        VM = new MainActivityViewModel();
        VM.getFruitLiveData().observe(
                this, new Observer<List<FruitResume>>() {
                    @Override
                    public void onChanged(List<FruitResume> fruitResumes) {
                        ((FruitListAdapter)recyclerView.getAdapter()).setFruitResumeList(fruitResumes);
                    }
                }
        );

    }

    private void setRecyclerViewConfiguration() {
        recyclerView = binding.RVMainActivity;
        recyclerView.setAdapter(new FruitListAdapter(new ArrayList<FruitResume>()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void searchFruit(View view) {
        VM.getData(binding.TVSearchBox.getText().toString());
    }
}
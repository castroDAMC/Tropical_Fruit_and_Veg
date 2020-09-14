package damc.castro.com.android.tropicalfruitandveg.View;

import androidx.appcompat.app.AppCompatActivity;
import damc.castro.com.android.tropicalfruitandveg.Controller.MainActivityController;
import damc.castro.com.android.tropicalfruitandveg.databinding.ActivityMainBinding;
import lombok.Data;

import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityController mMainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        try {
            mMainController = new MainActivityController(this);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ActivityMainBinding getBinding(){
        return this.binding;
    }


}
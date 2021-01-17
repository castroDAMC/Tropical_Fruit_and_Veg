package damc.castro.com.android.tropicalfruitandveg.View;

import androidx.appcompat.app.AppCompatActivity;

import damc.castro.com.android.tropicalfruitandveg.Controller.KMainActivityController;
import damc.castro.com.android.tropicalfruitandveg.Controller.MainActivityController;
import damc.castro.com.android.tropicalfruitandveg.databinding.ActivityMainBinding;
import lombok.Data;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityController mMainController;
    private KMainActivityController kMainActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //            mMainController = new MainActivityController(this);
        kMainActivityController = new KMainActivityController(this);
    }

    public ActivityMainBinding getBinding(){
        return this.binding;
    }


}
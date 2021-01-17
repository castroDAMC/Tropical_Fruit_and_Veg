package damc.castro.com.android.tropicalfruitandveg.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import damc.castro.com.android.tropicalfruitandveg.Controller.KMoreDetailsActivityController;
import damc.castro.com.android.tropicalfruitandveg.Controller.MoreDetailsActivityController;
import damc.castro.com.android.tropicalfruitandveg.databinding.ActivityItemDetailBinding;

public class MoreDetailsActivity extends AppCompatActivity {

    private ActivityItemDetailBinding binding;
    private String ftvitem = null;
    private KMoreDetailsActivityController mController;

    public String getFtvitem(){
        return this.ftvitem;
    }

    public ActivityItemDetailBinding getBinding(){
        return this.binding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityItemDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        ftvitem = intent.getStringExtra("ftvitem");

        mController = new KMoreDetailsActivityController(this);
    }
}

package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.mainmenu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.MainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

    private MainMenuBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}

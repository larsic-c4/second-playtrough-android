package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.mainmenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.MainMenuBinding;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.login.LoginActivity;

public class MainMenuActivity extends AppCompatActivity {

    private MainMenuBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.statistics.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, GamesScoreActivity.class);
            startActivity(intent);
        });

        binding.continueGame.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}

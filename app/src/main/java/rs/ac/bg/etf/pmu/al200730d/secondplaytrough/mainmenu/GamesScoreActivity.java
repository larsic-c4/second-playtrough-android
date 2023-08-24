package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.ActivityGamesScoreBinding;

public class GamesScoreActivity extends AppCompatActivity {

    private ActivityGamesScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamesScoreBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }
}
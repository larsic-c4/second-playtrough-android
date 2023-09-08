package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.mainmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import dagger.hilt.android.AndroidEntryPoint;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.ActivityGamesScoreBinding;

@AndroidEntryPoint
public class GamesScoreActivity extends AppCompatActivity {

    private ActivityGamesScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamesScoreBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.recyclerView.setHasFixedSize(true);
        //TODO get games from db
        binding.recyclerView.setAdapter(new GamesGroupedStatAdapter(null));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.mainmenu;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.GamesGrouped;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.ViewHolderGamesBinding;

public class GamesGroupedStatAdapter extends RecyclerView.Adapter<GamesGroupedStatAdapter.GGViewHolder> {

    private List<GamesGrouped> gamesGroupedList;

    public GamesGroupedStatAdapter(List<GamesGrouped> gamesGroupedList) {
        this.gamesGroupedList = gamesGroupedList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderGamesBinding binding = ViewHolderGamesBinding.inflate(
                inflater, parent, false);
        return new GGViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GGViewHolder holder, int position) {
        ViewHolderGamesBinding binding = holder.binding;
        binding.gamesScore.setText("Plavi : Crni - 5 : " + position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class GGViewHolder extends RecyclerView.ViewHolder{

        ViewHolderGamesBinding binding;

        public GGViewHolder(@NonNull ViewHolderGamesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

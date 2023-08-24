package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.mainmenu;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GamesGroupedStatAdapter extends RecyclerView.Adapter<GamesGroupedStatAdapter.GGViewHolder> {
    @NonNull
    @Override
    public GGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GGViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GGViewHolder extends RecyclerView.ViewHolder{

        public GGViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

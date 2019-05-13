package app.sandoval.com.shoppingmovies.ui.moviedetails.trailers;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.model.Trailer;

public class TrailersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Trailer> trailerList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TrailerViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Trailer trailer = trailerList.get(position);
        ((TrailerViewHolder) holder).bindTo(trailer);
    }

    @Override
    public int getItemCount() {
        return trailerList != null ? trailerList.size() : 0;
    }

    public void submitList(List<Trailer> trailers) {
        trailerList = trailers;
        notifyDataSetChanged();
    }
}


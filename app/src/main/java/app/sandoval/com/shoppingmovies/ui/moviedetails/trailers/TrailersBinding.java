package app.sandoval.com.shoppingmovies.ui.moviedetails.trailers;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.model.Trailer;

public class TrailersBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Trailer> items) {
        TrailersAdapter adapter = (TrailersAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}

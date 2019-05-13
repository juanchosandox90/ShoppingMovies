package app.sandoval.com.shoppingmovies.ui.moviedetails.reviews;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.model.Review;

public class ReviewsBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Review> items) {
        ReviewsAdapter adapter = (ReviewsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}

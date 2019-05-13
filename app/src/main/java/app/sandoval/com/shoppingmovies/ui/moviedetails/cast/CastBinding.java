package app.sandoval.com.shoppingmovies.ui.moviedetails.cast;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.model.Cast;

public class CastBinding {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Cast> items) {
        CastAdapter adapter = (CastAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}

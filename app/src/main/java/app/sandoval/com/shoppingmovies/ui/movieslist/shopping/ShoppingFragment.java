package app.sandoval.com.shoppingmovies.ui.movieslist.shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.sandoval.com.shoppingmovies.R;
import app.sandoval.com.shoppingmovies.data.local.model.Movie;
import app.sandoval.com.shoppingmovies.databinding.FragmentShoppingMoviesBinding;
import app.sandoval.com.shoppingmovies.ui.movieslist.MoviesActivity;
import app.sandoval.com.shoppingmovies.utils.Injection;
import app.sandoval.com.shoppingmovies.utils.ItemOffsetDecoration;
import app.sandoval.com.shoppingmovies.utils.ViewModelFactory;

public class ShoppingFragment extends Fragment {

    private ShoppingViewModel viewModel;
    private FragmentShoppingMoviesBinding binding;

    public static ShoppingFragment newInstance() {
        return new ShoppingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShoppingMoviesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((MoviesActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.shopping_car));
        viewModel = obtainViewModel(getActivity());
        setupListAdapter();
    }

    private void setupListAdapter() {
        RecyclerView recyclerView = binding.moviesList.rvMovieList;
        final ShoppingAdapter shoppingAdapter = new ShoppingAdapter();
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView.setAdapter(shoppingAdapter);
        recyclerView.setLayoutManager(layoutManager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

        viewModel.getShoppingListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movieList) {
                if (movieList.isEmpty()) {
                    binding.moviesList.rvMovieList.setVisibility(View.GONE);
                    binding.emptyState.setVisibility(View.VISIBLE);
                } else {
                    binding.moviesList.rvMovieList.setVisibility(View.VISIBLE);
                    binding.emptyState.setVisibility(View.GONE);
                    shoppingAdapter.submitList(movieList);
                }
            }
        });

    }

    private ShoppingViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = Injection.provideViewModelFactory(activity);
        return ViewModelProviders.of(activity, factory).get(ShoppingViewModel.class);
    }

}

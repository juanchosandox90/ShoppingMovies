package app.sandoval.com.shoppingmovies.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import app.sandoval.com.shoppingmovies.data.MovieRepository;
import app.sandoval.com.shoppingmovies.ui.movieslist.discover.DiscoverMoviesViewModel;
import app.sandoval.com.shoppingmovies.ui.movieslist.shopping.ShoppingViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final MovieRepository repository;

    public static ViewModelFactory getInstance(MovieRepository repository) {
        return new ViewModelFactory(repository);
    }

    private ViewModelFactory(MovieRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DiscoverMoviesViewModel.class)) {
            //noinspection unchecked
            return (T) new DiscoverMoviesViewModel(repository);
        } else if (modelClass.isAssignableFrom(ShoppingViewModel.class)) {
            //noinspection unchecked
            return (T) new ShoppingViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

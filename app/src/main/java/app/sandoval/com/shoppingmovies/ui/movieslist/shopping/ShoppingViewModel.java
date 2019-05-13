package app.sandoval.com.shoppingmovies.ui.movieslist.shopping;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.MovieRepository;
import app.sandoval.com.shoppingmovies.data.local.model.Movie;

public class ShoppingViewModel extends ViewModel {

    private LiveData<List<Movie>> shoppingListLiveData;

    public ShoppingViewModel(MovieRepository repository) {
        shoppingListLiveData = repository.getAllShopMovies();
    }

    public LiveData<List<Movie>> getShoppingListLiveData() {
        return shoppingListLiveData;
    }
}

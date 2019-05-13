package app.sandoval.com.shoppingmovies.ui.moviedetails;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import app.sandoval.com.shoppingmovies.R;
import app.sandoval.com.shoppingmovies.data.MovieRepository;
import app.sandoval.com.shoppingmovies.data.local.model.MovieDetails;
import app.sandoval.com.shoppingmovies.data.local.model.Resource;
import app.sandoval.com.shoppingmovies.utils.SnackbarMessage;
import timber.log.Timber;

public class MovieDetailsViewModel extends ViewModel {

    private final MovieRepository repository;

    private LiveData<Resource<MovieDetails>> result;

    private MutableLiveData<Long> movieIdLiveData = new MutableLiveData<>();

    private final SnackbarMessage mSnackbarText = new SnackbarMessage();

    private boolean isShop;

    public MovieDetailsViewModel(final MovieRepository repository) {
        this.repository = repository;
    }

    public void init(long movieId) {
        if (result != null) {
            return; // load movie details only once the activity created first time
        }
        Timber.d("Initializing viewModel");

        result = Transformations.switchMap(movieIdLiveData,
                new Function<Long, LiveData<Resource<MovieDetails>>>() {
                    @Override
                    public LiveData<Resource<MovieDetails>> apply(Long movieId) {
                        return repository.loadMovie(movieId);
                    }
                });

        setMovieIdLiveData(movieId); // trigger loading movie
    }

    public LiveData<Resource<MovieDetails>> getResult() {
        return result;
    }

    public SnackbarMessage getSnackbarMessage() {
        return mSnackbarText;
    }

    public boolean isShop() {
        return isShop;
    }

    public void setFavorite(boolean shop) {
        isShop = shop;
    }

    private void setMovieIdLiveData(long movieId) {
        movieIdLiveData.setValue(movieId);
    }

    public void retry(long movieId) {
        setMovieIdLiveData(movieId);
    }

    public void onShoppingClicked() {
        MovieDetails movieDetails = result.getValue().data;
        if (!isShop) {
            repository.shopMovie(movieDetails.movie);
            isShop = true;
            showSnackbarMessage(R.string.movie_added_successfully);
        } else {
            repository.unShopMovie(movieDetails.movie);
            isShop = false;
            showSnackbarMessage(R.string.movie_removed_successfully);
        }
    }

    private void showSnackbarMessage(Integer message) {
        mSnackbarText.setValue(message);
    }
}
package app.sandoval.com.shoppingmovies.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.model.Movie;
import app.sandoval.com.shoppingmovies.data.local.model.MovieDetails;
import app.sandoval.com.shoppingmovies.data.local.model.RepoMoviesResult;
import app.sandoval.com.shoppingmovies.data.local.model.Resource;
import app.sandoval.com.shoppingmovies.ui.movieslist.MoviesFilterType;

public interface DataSource {

    LiveData<Resource<MovieDetails>> loadMovie(long movieId);

    RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy);

    LiveData<List<Movie>> getAllShopMovies();

    void shopMovie(Movie movie);

    void unShopMovie(Movie movie);
}


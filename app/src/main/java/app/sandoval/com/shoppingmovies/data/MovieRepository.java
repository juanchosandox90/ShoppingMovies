package app.sandoval.com.shoppingmovies.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.MoviesLocalDataSource;
import app.sandoval.com.shoppingmovies.data.local.model.Movie;
import app.sandoval.com.shoppingmovies.data.local.model.MovieDetails;
import app.sandoval.com.shoppingmovies.data.local.model.RepoMoviesResult;
import app.sandoval.com.shoppingmovies.data.local.model.Resource;
import app.sandoval.com.shoppingmovies.data.remote.MoviesRemoteDataSource;
import app.sandoval.com.shoppingmovies.data.remote.api.ApiResponse;
import app.sandoval.com.shoppingmovies.ui.movieslist.MoviesFilterType;
import app.sandoval.com.shoppingmovies.utils.AppExecutors;
import timber.log.Timber;

public class MovieRepository implements DataSource {

    private static volatile MovieRepository sInstance;

    private final MoviesLocalDataSource mLocalDataSource;

    private final MoviesRemoteDataSource mRemoteDataSource;

    private final AppExecutors mExecutors;

    private MovieRepository(MoviesLocalDataSource localDataSource,
                            MoviesRemoteDataSource remoteDataSource,
                            AppExecutors executors) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
        mExecutors = executors;
    }

    public static MovieRepository getInstance(MoviesLocalDataSource localDataSource,
                                              MoviesRemoteDataSource remoteDataSource,
                                              AppExecutors executors) {
        if (sInstance == null) {
            synchronized (MovieRepository.class) {
                if (sInstance == null) {
                    sInstance = new MovieRepository(localDataSource, remoteDataSource, executors);
                }
            }
        }
        return sInstance;
    }

    @Override
    public LiveData<Resource<MovieDetails>> loadMovie(final long movieId) {
        return new NetworkBoundResource<MovieDetails, Movie>(mExecutors) {

            @Override
            protected void saveCallResult(@NonNull Movie item) {
                mLocalDataSource.saveMovie(item);
                Timber.d("Movie added to database");
            }

            @Override
            protected boolean shouldFetch(@Nullable MovieDetails data) {
                return data == null; // only fetch fresh data if it doesn't exist in database
            }

            @NonNull
            @Override
            protected LiveData<MovieDetails> loadFromDb() {
                Timber.d("Loading movie from database");
                return mLocalDataSource.getMovie(movieId);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<Movie>> createCall() {
                Timber.d("Downloading movie from network");
                return mRemoteDataSource.loadMovie(movieId);
            }

            @NonNull
            @Override
            protected void onFetchFailed() {
                // ignored
                Timber.d("Fetch failed!!");
            }
        }.getAsLiveData();
    }

    @Override
    public RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy) {
        return mRemoteDataSource.loadMoviesFilteredBy(sortBy);
    }

    @Override
    public LiveData<List<Movie>> getAllShopMovies() {
        return mLocalDataSource.getAllShopMovies();
    }

    @Override
    public void shopMovie(final Movie movie) {
        mExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                Timber.d("Adding movie to Shopping");
                mLocalDataSource.shopMovie(movie);
            }
        });
    }

    @Override
    public void unShopMovie(final Movie movie) {
        mExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                Timber.d("Removing movie from Shopping");
                mLocalDataSource.unShopMovie( movie);
            }
        });
    }
}

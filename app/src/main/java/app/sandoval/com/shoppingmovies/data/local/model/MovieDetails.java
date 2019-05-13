package app.sandoval.com.shoppingmovies.data.local.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to load full movie details including (Trailers, Cast, etc)
 */

public class MovieDetails {

    @Embedded
    public Movie movie = null;

    @Relation(parentColumn = "id", entityColumn = "movie_id")
    public List<Trailer> trailers = new ArrayList<>();

    @Relation(parentColumn = "id", entityColumn = "movie_id")
    public List<Cast> castList = new ArrayList<>();

    @Relation(parentColumn = "id", entityColumn = "movie_id")
    public List<Review> reviews = new ArrayList<>();
}

package app.sandoval.com.shoppingmovies.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import java.util.List;

import app.sandoval.com.shoppingmovies.data.local.model.Cast;

@Dao
public interface CastsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllCasts(List<Cast> castList);

}

package kg.geektech.courses.android3.lesson1sept.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmSpecies;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;

@Dao
public interface FilmDao extends IAppStorage {

//    @Insert(onConflict = OnConflictStrategy.REPLACE )
//    void insertFilm(FilmModel filmModel);
//
//    @Query("SELECT * FROM FilmModel")
//    List<FilmModel> filmModels();

    @Override
    @Query("SELECT * FROM FilmModel")
    List<FilmModel> getFilmModels();

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addFilm(FilmModel filmModel);

    @Delete
    @Override
    void deleteFilm(FilmModel filmModel);

    @Query("SELECT * FROM FilmModel WHERE FilmModel.id=:id")
    @Override
    FilmModel getFilmById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpecies(List<SpeciesModel> speciesModels);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Override
    void insertSpeciesOne(SpeciesModel speciesModels);

    @Query("SELECT * FROM SpeciesModel WHERE SpeciesModel.id =:id")
    List<SpeciesModel> getSpeciesById(String id);

    @Transaction
    @Query("SELECT * FROM FilmModel")
    @Override
    List<FilmSpecies> getAllSpecies();

    @Transaction
    @Query("SELECT * FROM FilmModel WHERE FilmModel.id =:id")
    @Override
    FilmSpecies getSpecies(String id);
}

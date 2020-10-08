package kg.geektech.courses.android3.lesson1sept.data.local;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmSpecies;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;

public interface IAppStorage {

    void addFilm(FilmModel filmModel);
    List<FilmModel> getFilmModels();
    void deleteFilm(FilmModel filmModel);
    FilmModel getFilmById(String id);
    void insertSpeciesOne(SpeciesModel speciesModels);
    List<FilmSpecies> getAllSpecies();
    FilmSpecies getSpecies(String id);

}

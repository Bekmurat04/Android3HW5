package kg.geektech.courses.android3.lesson1sept.data.network;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface IAppNetwork {

    Call<FilmModel> getFilmById(String filmId);

    Call<List<FilmModel>> getFilms();

    Call<SpeciesModel> getSpecies(String url);

}

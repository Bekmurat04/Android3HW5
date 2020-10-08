package kg.geektech.courses.android3.lesson1sept.data.network;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GhibliApi extends IAppNetwork {
//    @GET("films/{filmId}")
//    Call<FilmModel> getFilmById(
//            @Path("filmId") String filmId
//    );
//
//    @GET("films")
//    Call<List<FilmModel>> getFilms();
//
//    @GET
//    Call<SpeciesModel> getSpecies(@Url String url);

    @GET("films/{filmId}")
    @Override
    Call<FilmModel> getFilmById(@Path("filmId") String filmId);

    @GET("films")
    @Override
    Call<List<FilmModel>> getFilms();

    @GET
    @Override
    Call<SpeciesModel> getSpecies(@Url String url);

    //        @GET("{url}")
//        Call<SpeciesModel> getSpecies(@Path(value = "url",encoded = true)String url);

}


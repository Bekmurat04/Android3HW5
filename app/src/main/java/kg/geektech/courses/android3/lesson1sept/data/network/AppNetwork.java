package kg.geektech.courses.android3.lesson1sept.data.network;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.local.IAppStorage;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;
import retrofit2.Call;

public class AppNetwork {

    private IAppNetwork iAppNetwork;

    public AppNetwork(IAppNetwork iAppNetwork){
        this.iAppNetwork = iAppNetwork;
    }

    public Call<FilmModel> getFilmById(String filmId){
        return iAppNetwork.getFilmById(filmId);
    }

    public Call<List<FilmModel>> getFilms(){
        return iAppNetwork.getFilms();
    }

    public Call<SpeciesModel> getSpecies(String url){
        return iAppNetwork.getSpecies(url);
    }
}

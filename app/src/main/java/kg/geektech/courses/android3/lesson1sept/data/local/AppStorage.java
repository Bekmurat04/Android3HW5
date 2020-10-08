package kg.geektech.courses.android3.lesson1sept.data.local;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmSpecies;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;

public class AppStorage {

    private IAppStorage storage;

    public AppStorage(IAppStorage iAppStorage){
        storage = iAppStorage;
    }

    public void addFilm(FilmModel filmModel){
        storage.addFilm(filmModel);
    }
    public List<FilmModel> getFilmModels(){
        return storage.getFilmModels();
    }
    public void deleteFilm(FilmModel filmModel){
        storage.deleteFilm(filmModel);
    }
    public FilmModel getFilmById(String id){
        return storage.getFilmById(id);
    }
    public void insertSpeciesOne(SpeciesModel speciesModels){
        storage.insertSpeciesOne(speciesModels);
    }
    public List<FilmSpecies> getAllSpecies(){
        return storage.getAllSpecies();
    }
    public FilmSpecies getSpecies(String id){
        return storage.getSpecies(id);
    }

}

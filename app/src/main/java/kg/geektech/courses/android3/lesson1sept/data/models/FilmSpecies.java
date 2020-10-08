package kg.geektech.courses.android3.lesson1sept.data.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.Arrays;
import java.util.List;

public class FilmSpecies {

    @Embedded
    public FilmModel filmModel;

    @Relation(parentColumn = "id",entityColumn = "filmId")
    public List<SpeciesModel> speciesModels;

    @Override
    public String toString() {
        return "FilmSpecies{" +
                "filmModel=" + filmModel.getDirector() +
                ", speciesModels=" + Arrays.toString(speciesModels.toArray()) +
                '}';
    }
}

package kg.geektech.courses.android3.lesson1sept.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;

@Database(entities = {FilmModel.class, SpeciesModel.class},version = 1)
public abstract class FilmDatabase extends RoomDatabase {

    public abstract FilmDao filmDao();

}

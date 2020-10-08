package kg.geektech.courses.android3.lesson1sept;

import android.app.Application;

import androidx.room.Room;

import kg.geektech.courses.android3.lesson1sept.data.local.AppStorage;
import kg.geektech.courses.android3.lesson1sept.data.local.PreferenceUtils;
import kg.geektech.courses.android3.lesson1sept.data.local.FilmDatabase;
import kg.geektech.courses.android3.lesson1sept.data.network.AppNetwork;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliService;

public class App extends Application {

    public static AppStorage storage;
    public static AppNetwork network;

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceUtils.init(this);
        FilmDatabase filmDatabase = Room.databaseBuilder(this,FilmDatabase.class,"FilmDatabse")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        storage = new AppStorage(filmDatabase.filmDao());
        network = new AppNetwork(GhibliService.getClient());
    }
}

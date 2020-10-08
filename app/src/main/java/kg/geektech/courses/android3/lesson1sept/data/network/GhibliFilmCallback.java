package kg.geektech.courses.android3.lesson1sept.data.network;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;

public interface GhibliFilmCallback {
    void onSuccess(FilmModel filmModel);

    void onFailure(Throwable ex);
}

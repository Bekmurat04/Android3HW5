package kg.geektech.courses.android3.lesson1sept.data.network;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;

public interface GhibliFilmsCallback{
    void onSuccess(List<FilmModel> filmModel);

    void onFailure(Throwable ex);
}

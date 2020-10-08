package kg.geektech.courses.android3.lesson1sept.data.network;


import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;

public interface GhibliSpeciesCallBack{
    void onSuccess(SpeciesModel speciesModel);

    void onFailure(Throwable ex);
}

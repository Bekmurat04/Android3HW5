package kg.geektech.courses.android3.lesson1sept.data.network;

import kg.geektech.courses.android3.lesson1sept.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GhibliService {

    private static GhibliApi ghibliApi;

    public static GhibliApi getClient(){
        if (ghibliApi == null){
            ghibliApi = retrofitBuilder();
        }else {
            return ghibliApi;
        }
        return ghibliApi;
    }

    public static GhibliApi retrofitBuilder(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GhibliApi.class);
    }

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BuildConfig.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    GhibliApi service = retrofit.create(GhibliApi.class);
//
//    public void getFilmById(String id, GhibliFilmCallback callback) {
//        Call<FilmModel> call = service.getFilmById(id);
//        call.enqueue(new Callback<FilmModel>() {
//            @Override
//            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    callback.onSuccess(response.body());
//                    Log.d("tag", response.body().getTitle());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<FilmModel> call, Throwable t) {
//                callback.onFailure(t);
//                Log.d("tag", "Failure");
//            }
//        });
//    }
//
//    public void getFilms(GhibliFilmsCallback ghibliFilmCallback) {
//        Call<List<FilmModel>> listCall = service.getFilms();
//        listCall.enqueue(new Callback<List<FilmModel>>() {
//            @Override
//            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
//                ghibliFilmCallback.onSuccess(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
//                ghibliFilmCallback.onFailure(t);
//            }
//        });
//    }
//
//    public void getSpecies(String speciesId, GhibliSpeciesCallBack ghibliSpeciesCallBack) {
//        Call<SpeciesModel> modelCall = service.getSpecies(speciesId);
//        modelCall.enqueue(new Callback<SpeciesModel>() {
//            @Override
//            public void onResponse(Call<SpeciesModel> call, Response<SpeciesModel> response) {
//                if (response.isSuccessful()) {
//                    ghibliSpeciesCallBack.onSuccess(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SpeciesModel> call, Throwable t) {
//                Log.d("Fail", t.getMessage());
//                t.printStackTrace();
//                ghibliSpeciesCallBack.onFailure(t);
//            }
//        });
//    }
}

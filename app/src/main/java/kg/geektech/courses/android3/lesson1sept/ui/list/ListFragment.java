package kg.geektech.courses.android3.lesson1sept.ui.list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.courses.android3.lesson1sept.App;
import kg.geektech.courses.android3.lesson1sept.R;
import kg.geektech.courses.android3.lesson1sept.adapters.mainA.MainAdapter;
import kg.geektech.courses.android3.lesson1sept.adapters.mainA.OnFilmClickListener;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliFilmCallback;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliFilmsCallback;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliSpeciesCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {

    public static final String FILM_ID = "filmId";
    public static final String IS_NETWORK = "network";

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<FilmModel> filmModels = new ArrayList<>();

    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.films_recycler);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

//        App.ghibliService.getFilmById("58611129-2dbc-4a81-a72f-77ddfc1b1b49", new GhibliFilmCallback() {
//            @Override
//            public void onSuccess(FilmModel filmModel) {
//                Log.d("GG", filmModel.getDirector());
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//
//            }
//        });

//        App.ghibliService.getFilms(new GhibliFilmsCallback() {
//            @Override
//            public void onSuccess(List<FilmModel> filmModel) {
//                Log.d("GHIBLI", String.valueOf(filmModel.size()));
//                filmModels = filmModel;
//                mainAdapter.setFilmModels(filmModel);
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                Log.d("GHIBLI", ex.getMessage());
//            }
//        });
        App.network.getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful()){
                Log.d("GHIBLI", String.valueOf(response.body().size()));
                filmModels = response.body();
                mainAdapter.setFilmModels(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                Log.d("g",t.getMessage());
            }
        });

        mainAdapter.setListener(new OnFilmClickListener() {
            @Override
            public void onClick(int position) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(FILM_ID, filmModels.get(position).getId());
                bundle.putBoolean(IS_NETWORK, true);
//                navController.setGraph(R.navigation.film_graph,bundle);
                navController.navigate(R.id.action_listFragment_to_filmFragment, bundle);
            }

            @Override
            public void save(int position) {
                saveFilm(position);
            }
        });
    }

    private void saveFilm(int position) {
        App.storage.addFilm(filmModels.get(position));
        String filmId = filmModels.get(position).getId();
        ArrayList<String> strings = (ArrayList<String>) filmModels.get(position).getSpecies();
        for (int i = 0; i < strings.size(); i++) {
            Log.d("kk", "l");
            App.network.getSpecies(strings.get(i)).enqueue(new Callback<SpeciesModel>() {
                @Override
                public void onResponse(Call<SpeciesModel> call, Response<SpeciesModel> response) {
                    if (response.isSuccessful()) {
                        Log.d("kk", response.body().getName());
                        SpeciesModel speciesModel1 = response.body();
                        speciesModel1.setFilmId(filmId);
                        App.storage.insertSpeciesOne(speciesModel1);
                    }
                }

                @Override
                public void onFailure(Call<SpeciesModel> call, Throwable t) {
                    Log.d("Fail",t.getMessage());
                }
            });
//            App.ghibliService.getSpecies(strings.get(i), new GhibliSpeciesCallBack() {
//                @Override
//                public void onSuccess(SpeciesModel speciesModel) {
//                    if (speciesModel != null){
//                        Log.d("kk",speciesModel.getName());
//                        SpeciesModel speciesModel1 = speciesModel;
//                        speciesModel1.setFilmId(filmId);
//                        App.storage.insertSpeciesOne(speciesModel1);
//                    }
//                }
//
//                @Override
//                public void onFailure(Throwable ex) {
//                    Log.d("Fail",ex.getMessage());
//                }
//            });
        }
        Toast.makeText(requireContext(), "Фильм сохранен!", Toast.LENGTH_SHORT).show();
        Log.d("new", App.storage.getAllSpecies().toString());
    }
}
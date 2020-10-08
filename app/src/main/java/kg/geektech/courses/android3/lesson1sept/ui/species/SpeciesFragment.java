package kg.geektech.courses.android3.lesson1sept.ui.species;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kg.geektech.courses.android3.lesson1sept.App;
import kg.geektech.courses.android3.lesson1sept.R;
import kg.geektech.courses.android3.lesson1sept.adapters.speciesA.SpeciesAdapter;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliService;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliSpeciesCallBack;
import kg.geektech.courses.android3.lesson1sept.ui.filmF.FilmFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpeciesFragment extends Fragment {

    RecyclerView recyclerView;
    SpeciesAdapter speciesAdapter;
    ArrayList<String> speciesModels = new ArrayList<>();
    ArrayList<SpeciesModel> models = new ArrayList<>();
    boolean isFromNetwork = false;
    public SpeciesFragment() {
        // Required empty public constructor
    }

    public static SpeciesFragment newInstance(String param1, String param2) {
        SpeciesFragment fragment = new SpeciesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            speciesModels= getArguments().getStringArrayList(FilmFragment.SPECIES);
            isFromNetwork= getArguments().getBoolean(FilmFragment.LOCAL);
            Log.d("kk", String.valueOf(getArguments().getStringArrayList(FilmFragment.SPECIES).size()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_species, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.species_recycler);
        speciesAdapter = new SpeciesAdapter();
        recyclerView.setAdapter(speciesAdapter);
        if (isFromNetwork) {
            getFromNetwork();
        } else {
            getFromRoom();
        }

    }

    private void getFromRoom() {
        for (int i = 0; i < speciesModels.size() ; i++) {
            String filmId = speciesModels.get(i);
            models = (ArrayList<SpeciesModel>)
                     App.storage
                     .getSpecies(filmId)
                    .speciesModels;
        }
        for (int i = 0; i <models.size()  ; i++) {
            speciesAdapter.setSpeciesModels(models.get(i));
        }
    }

    private void getFromNetwork() {
        for (int i = 0; i < speciesModels.size(); i++) {
            Log.d("kk","l");
//            App.ghibliService.getSpecies(speciesModels.get(i), new GhibliSpeciesCallBack() {
//                @Override
//                public void onSuccess(SpeciesModel speciesModel) {
//                    if (speciesModel != null){
//                        Log.d("kk",speciesModel.getName());
//                        speciesAdapter.setSpeciesModels(speciesModel);
//                    }
//                }
//
//                @Override
//                public void onFailure(Throwable ex) {
//                    Log.d("Fail",ex.getMessage());
//                }
//            });
            App.network.getSpecies(speciesModels.get(i)).enqueue(new Callback<SpeciesModel>() {
                @Override
                public void onResponse(Call<SpeciesModel> call, Response<SpeciesModel> response) {
                    if (response.isSuccessful()){
                        Log.d("kk",response.body().getName());
                        speciesAdapter.setSpeciesModels(response.body());
                    }
                }

                @Override
                public void onFailure(Call<SpeciesModel> call, Throwable t) {
                    Log.d("Fail",t.getMessage());
                }
            });
        }
    }
}
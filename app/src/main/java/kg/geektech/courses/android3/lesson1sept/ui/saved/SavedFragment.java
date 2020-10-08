package kg.geektech.courses.android3.lesson1sept.ui.saved;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.courses.android3.lesson1sept.App;
import kg.geektech.courses.android3.lesson1sept.R;
import kg.geektech.courses.android3.lesson1sept.adapters.mainA.MainAdapter;
import kg.geektech.courses.android3.lesson1sept.adapters.mainA.OnFilmClickListener;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.ui.list.ListFragment;

public class SavedFragment extends Fragment {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<FilmModel> filmModels;

    public static SavedFragment newInstance(String param1, String param2) {
        SavedFragment fragment = new SavedFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.saved_recycler_view);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);
        filmModels = (App.storage.getFilmModels());
        mainAdapter.setFilmModels(filmModels);
        click();
    }

    private void click() {
        mainAdapter.setListener(new OnFilmClickListener() {
            @Override
            public void onClick(int position) {
                NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString(ListFragment.FILM_ID,filmModels.get(position).getId());
                bundle.putBoolean(ListFragment.IS_NETWORK,false);
//                navController.setGraph(R.navigation.film_graph,bundle);
                navController.navigate(R.id.action_save_item_to_filmFragment,bundle);
            }

            @Override
            public void save(int position) {
                App.storage.deleteFilm(filmModels.get(position));
                filmModels.remove(position);
                mainAdapter.setFilmModels(filmModels);
            }
        });
    }
}
package kg.geektech.courses.android3.lesson1sept.adapters.speciesA;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kg.geektech.courses.android3.lesson1sept.R;
import kg.geektech.courses.android3.lesson1sept.data.models.SpeciesModel;

public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder> {

    ArrayList<SpeciesModel> speciesModels = new ArrayList<>();

    public void setSpeciesModels(SpeciesModel speciesModels){
        this.speciesModels.add(speciesModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SpeciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpeciesViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.species_view_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesViewHolder holder, int position) {
        holder.onBind(speciesModels.get(position).getName()
        ,speciesModels.get(position).getClassification(),speciesModels.get(position).getEyeColors()
        ,speciesModels.get(position).getHairColors());
    }

    @Override
    public int getItemCount() {
        return speciesModels.size();
    }

    public class SpeciesViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView classification;
        TextView eyeColor;
        TextView hairColors;

        private static final String NAME = "Name: ";
        private static final String CLASSIFICATION = "Classification: ";
        private static final String EYE_COLOR = "EyeColor: ";
        private static final String HAIR_COLORS = "HairColors: ";

        public SpeciesViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_species_tv);
            classification = itemView.findViewById(R.id.classification_species_tv);
            eyeColor = itemView.findViewById(R.id.eye_color_species_tv);
            hairColors = itemView.findViewById(R.id.hair_colors_species_tv);
        }

        public void onBind(String name,String classification,String eyeColor,String hairColor){
            this.name.setText(NAME + name);
            this.classification.setText(CLASSIFICATION + classification);
            this.eyeColor.setText(EYE_COLOR + eyeColor);
            this.hairColors.setText(HAIR_COLORS + hairColor);
        };

    }

}

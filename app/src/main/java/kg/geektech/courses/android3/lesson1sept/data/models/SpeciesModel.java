
package kg.geektech.courses.android3.lesson1sept.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class SpeciesModel {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @NonNull
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("classification")
    @Expose
    private String classification;
    @SerializedName("eye_colors")
    @Expose
    private String eyeColors;
    @SerializedName("hair_colors")
    @Expose
    private String hairColors;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("people")
    @Expose
    @Ignore
    private List<String> people = null;
    @SerializedName("films")
    @Expose
    @Ignore
    private List<String> films = null;
    @SerializedName("length")
    @Expose
    @Ignore
    private Object length;

    private String filmId;

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

}

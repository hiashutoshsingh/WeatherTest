package ashu.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Model {

    @SerializedName("main")
    @Expose
    private MainModel mainModel;
    @SerializedName("weather")
    @Expose
    private List<WeatherList> weatherLists;

    public Model(MainModel mainModel, List<WeatherList> weatherLists) {
        this.mainModel = mainModel;
        this.weatherLists = weatherLists;
    }

    public List<WeatherList> getWeatherLists() {
        return weatherLists;
    }

    public void setWeatherLists(List<WeatherList> weatherLists) {
        this.weatherLists = weatherLists;
    }

    public MainModel getMainModel() {
        return mainModel;
    }

    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public static class WeatherList implements Serializable {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("main")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }

        public WeatherList(int id, String name, String description, String icon) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.icon = icon;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}

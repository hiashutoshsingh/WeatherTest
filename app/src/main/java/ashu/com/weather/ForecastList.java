package ashu.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ForecastList {
    @SerializedName("main")
    @Expose
    MainWeather mainWeather;
    @SerializedName("weather")
    @Expose
    List<ForecastWeatherList> forecastWeatherList;
    @SerializedName("dt_txt")
    @Expose
    String date;

    public ForecastList(MainWeather mainWeather, List<ForecastWeatherList> forecastWeatherList, String date) {
        this.mainWeather = mainWeather;
        this.forecastWeatherList = forecastWeatherList;
        this.date = date;
    }

    public MainWeather getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(MainWeather mainWeather) {
        this.mainWeather = mainWeather;
    }

    public List<ForecastWeatherList> getForecastWeatherList() {
        return forecastWeatherList;
    }

    public void setForecastWeatherList(List<ForecastWeatherList> forecastWeatherList) {
        this.forecastWeatherList = forecastWeatherList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public static class ForecastWeatherList implements Serializable {

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

        public ForecastWeatherList(int id, String name, String description, String icon) {
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

    public class MainWeather {
        @SerializedName("temp")
        @Expose
        private Double temp;
        @SerializedName("temp_min")
        @Expose
        private Double tempMin;
        @SerializedName("temp_max")
        @Expose
        private Double tempMax;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }
    }
}

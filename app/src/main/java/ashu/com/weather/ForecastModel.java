package ashu.com.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ForecastModel {

    @SerializedName("list")
    @Expose
    List<ForecastList> forecastList ;

    public List<ForecastList> getForecastList() {
        return forecastList;
    }

    public ForecastModel(List<ForecastList> forecastList) {
        this.forecastList = forecastList;
    }

    public void setForecastList(List<ForecastList> forecastList) {
        this.forecastList = forecastList;
    }
}

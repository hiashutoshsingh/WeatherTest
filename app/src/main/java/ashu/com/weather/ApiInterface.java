package ashu.com.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather")
    Call<Model> getWeather(@Query("q") String city, @Query("appid") String apiKey);

    @GET("forecast")
    Call<ForecastModel> getForecast(@Query("q") String city, @Query("appid") String apiKey);
}

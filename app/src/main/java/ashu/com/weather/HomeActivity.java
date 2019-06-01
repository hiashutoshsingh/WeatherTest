package ashu.com.weather;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    String str_city;
    @BindView(R.id.city_name)
    TextView cityName;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.tempStatus)
    TextView tempStatus;
    @BindView(R.id.maxTemp)
    TextView maxTemp;
    @BindView(R.id.img_weather)
    ImageView img;
    @BindView(R.id.minTemp)
    TextView minTemp;
    @BindView(R.id.forecastRecyclerView)
    RecyclerView recyclerView;
    ForecastAdapter forecastAdapter;
    @BindView(R.id.refresh)
    SwipeRefreshLayout pullToRefresh;
    ArrayList<ForecastModel> forecastModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        str_city = intent.getStringExtra("city");
        cityName.setText(str_city);

        callApi();

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callApi();
                Toast.makeText(HomeActivity.this, "Content Refreshed!", Toast.LENGTH_SHORT).show();
                pullToRefresh.setRefreshing(false);
            }
        });


        Handler handler = new Handler();
        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(HomeActivity.this, "Content Refreshed after 5 mins!", Toast.LENGTH_SHORT).show();
            }
        };
        handler.postDelayed(runnableCode, 300000);

    }

    private void callApi() {
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call call = apiInterface.getWeather(str_city, Config.api_key);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                Model model = (Model) response.body();
                temp.setText(Double.toString(model.getMainModel().getTemp()));
                minTemp.setText(Double.toString(model.getMainModel().getTempMin()));
                maxTemp.setText(Double.toString(model.getMainModel().getTempMax()));
                tempStatus.setText(model.getWeatherLists().get(0).getName());

                String imgLink = "https://openweathermap.org/img/w/" + model.getWeatherLists().get(0).getIcon() + ".png";
                Picasso.get().load(imgLink).into(img);

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Try Again!", Toast.LENGTH_LONG);
            }
        });

        Call call1 = apiInterface.getForecast(str_city, Config.api_key);
        call1.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                //forecastModels = new ArrayList<>();
                ForecastModel forecastModel = (ForecastModel) response.body();
                recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, true));
                forecastAdapter = new ForecastAdapter(forecastModel, HomeActivity.this);
                recyclerView.setAdapter(forecastAdapter);
                forecastAdapter.notifyDataSetChanged();

                //Log.d("ashu", "list: " + forecastModel.getForecastList().get(0).getForecastWeatherList().get(0).getIcon());


            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ashu", "Forecast error: " + t);
            }
        });

    }
}

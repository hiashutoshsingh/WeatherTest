package ashu.com.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastHolder> {

    Context context;
    ForecastModel forecastModel;

    public ForecastAdapter(ForecastModel forecastModel, Context context) {
        this.forecastModel = forecastModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ForecastHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.item_forecase_layout, parent, false);
        final ForecastHolder viewHolder = new ForecastHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastHolder holder, int position) {

        String imgLink = "https://openweathermap.org/img/w/" + forecastModel.getForecastList().get(0).getForecastWeatherList().get(0).getIcon() + ".png";
        Picasso.get().load(imgLink).into(holder.img);

        holder.day.setText(forecastModel.getForecastList().get(position).getDate());
        String min= Double.toString(forecastModel.forecastList.get(position).getMainWeather().getTempMin());
        String max= Double.toString(forecastModel.forecastList.get(position).getMainWeather().getTempMax());
        holder.minMaxTemp.setText(min+"/"+max);


    }

    @Override
    public int getItemCount() {
        return forecastModel.getForecastList().size();
    }

    public class ForecastHolder extends RecyclerView.ViewHolder {

        TextView day;
        TextView minMaxTemp;
        ImageView img;

        public ForecastHolder(@NonNull View itemView) {
            super(itemView);

            day = (TextView) itemView.findViewById(R.id.weekDay);
            minMaxTemp = (TextView) itemView.findViewById(R.id.minMaxTemp);
            img = (ImageView) itemView.findViewById(R.id.forecastImage);
        }
    }
}

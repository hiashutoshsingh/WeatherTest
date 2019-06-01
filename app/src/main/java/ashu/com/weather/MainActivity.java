package ashu.com.weather;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText_cityName)
    EditText city_editext;
    @BindView(R.id.button_go)
    Button button;
    String str_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.button_go)
    public void submit(View view) {

        str_city = city_editext.getText().toString().trim();
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("city", str_city);
        if (str_city.isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Empty");
            alertDialog.setMessage("Please input the city");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else startActivity(intent);
    }
}

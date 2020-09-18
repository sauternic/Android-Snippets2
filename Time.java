package android.example.time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.ausgabe);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        textView.setText(simpleDateFormat.format(new Date()));

    }
}
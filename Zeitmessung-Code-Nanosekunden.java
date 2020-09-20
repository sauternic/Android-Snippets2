package android.example.bung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {

    private TextView ausgabe;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ausgabe = findViewById(R.id.ausgabe);

        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator('\'');

        DecimalFormat df = new DecimalFormat("#,##0", decimalFormatSymbols);


        long zeit1 = System.nanoTime();
        // Hier zu messender Code rein////////////////////////////////////////////////////////

        //SystemClock.sleep(0);

        // Ende zu messender Code/////////////////////////////////////////////////////////////
        long zeit2 = System.nanoTime();

        // Nanosekunden = Miliardstel-Sekunde
        Log.d("meinTag", df.format(zeit2 - zeit1) + " Nanosekunden");
    }
}
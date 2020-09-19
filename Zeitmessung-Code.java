package android.example.zeitmessung_code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        long nanoTime1 = System.nanoTime();
        // Hier zu messender Code rein!/////////////////////////////////////

        //SystemClock.sleep(1000);

        // Ende des zu messenden Codes!//////////////////////////////////////
        long nanoTime2 = System.nanoTime();


        long ergebnis = nanoTime2 - nanoTime1;

        // long in double Konvertieren um zu Teilen für Milisekunden Ausgabe
        double double_ergebnis = Double.parseDouble(String.valueOf(ergebnis)) ;

        double double_millisekunden = double_ergebnis/1000000;
        Log.d("mein_TAG", String.valueOf(double_millisekunden + " Milisekunden"));
    }
}
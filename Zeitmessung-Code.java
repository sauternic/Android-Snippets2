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
        
		     //Code to be measured in here
        
		long nanoTime2 = System.nanoTime();


        long ergebnis = nanoTime2 - nanoTime1;

        // long to double convert, to split for millisecond output
        double double_ergebnis = Double.parseDouble(String.valueOf(ergebnis)) ;

        double double_millisekunden = double_ergebnis/1000000;
        Log.d("mein_TAG", String.valueOf(double_millisekunden + " milliseconds"));
    }
}


// In Kotlin: %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

package android.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nanoTime1 = System.nanoTime()

            //Code to be measured in here

        val nanoTime2 = System.nanoTime()
        val res = nanoTime2 - nanoTime1

        // Nano to milliseconds
        val res_m = res.toDouble() / 1000000

        Log.d("TAG", "Result in milliseconds: $res_m")
    }
}
// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

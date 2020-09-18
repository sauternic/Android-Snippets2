package android.example.looper_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ExampleLooperThread";
    private ExampleLooperThread exampleLooperThread;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.ausgabe);

        exampleLooperThread = new ExampleLooperThread();
    }

    public void onClick_start(View view) {

        exampleLooperThread.start();

    }

    public void onClick_stop(View view) {

        exampleLooperThread = null;
        exampleLooperThread = new ExampleLooperThread();

    }

    public void onClick_A(View view) {
        exampleLooperThread.handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    final int ii = i;
                    SystemClock.sleep(1000);
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(ii));
                        }
                    });

                    Log.d(TAG, "run: " + ii + " " + Thread.currentThread().getName());
                }
            }
        });
    }

    public void onClick_B(View view) {
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////

package android.example.looper_handler;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import java.time.Clock;

class ExampleLooperThread extends Thread {

    //Handler mit hintergrund Thread Raussenden!
    public Handler handler;

    @Override
    public void run() {

        Looper.prepare();

        //Handler saugt aktuellen hintergrund Thread auf!!! :)))
        handler = new Handler();

        Looper.loop();

    }
}

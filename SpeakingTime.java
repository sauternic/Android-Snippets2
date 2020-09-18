package android.example.speakingtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private SimpleDateFormat simpleDateFormat;
    private String vergleich = "";
    private TextToSpeech textToSpeech;
    private boolean bereit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        textToSpeech = new TextToSpeech(this, this);
    }


    // Muss rein weil Interace Methode von TextToSpeech.OnInitListener
    @Override
    public void onInit(int i) {
        // Bei Komplexen Programmen lieber weglassen!!! :(((
        bereit = true;
    }

    public void onClick_helloworld(View view) {
        // Zeitausgabe Aufrufen

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    zeitSprechen(simpleDateFormat.format(new Date()));
                    SystemClock.sleep(1000);
                    // Verlassen der Schleife und run Methode, nicht UI Thread wird beendet
                    if(false){
                        break;
                    }
                }
            }
        }).start();
    }

    private void zeitSprechen(String time) {

        if (textToSpeech == null) {
            textToSpeech = new TextToSpeech(this, this);
        }

        if (bereit) {
            if (time.equals(vergleich)) {
                //Wenn gleich nichts machen
            } else {
                //Ausgeben wenn Ungleich
                if (textToSpeech != null) {
                    textToSpeech.speak(time, TextToSpeech.QUEUE_ADD, null);
                }
                vergleich = time;
            }
        }

    }
}
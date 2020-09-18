package android.example.sound1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.aauuuh);

    }

    public void onClick_button(View view) {
        for (int i = 0; i < 1; i++) {
            mediaPlayer.start();
            //SystemClock.sleep(1500);
        }
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

    public void onClick_button2(View view) {
        mediaPlayer.pause();
    }
}
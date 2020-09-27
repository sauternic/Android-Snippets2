
MainActivity.java:
////////////////////////////////////////////////////////////////////////////////
package android.example.gebunden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyService myService = null;
                      ---------
    private TextView ausgabe;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder localBinder = (MyService.LocalBinder)service;
            myService = localBinder.getService();
            ---------
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
            ---------
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ausgabe = findViewById(R.id.ausgabe);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        myService = null;
        ---------
    }

    public void onClick_button(View view) {
        int i = myService.malZwei(5);
        ausgabe.setText(String.valueOf(i));
    }
}
////////////////////////////////////////////////////////////////////////////////

MyService.java
////////////////////////////////////////////////////////////////////////////////
package android.example.gebunden;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private final IBinder mBinder = new LocalBinder();
                          -------       xxxxxxxxxxx

    class LocalBinder extends Binder {
          xxxxxxxxxxx
        MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return mBinder;
	          -------
    }

    public int malZwei(int x){
        return  x * 2;
    }
}
//////////////////////////////////////////////////////////////////////////////////

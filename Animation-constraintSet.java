package android.example.aconst;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick_button(View view) {

        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = findViewById(R.id.main_activity);

        constraintSet.clone(constraintLayout);

        // Zugriff auf Einstellungen
        constraintSet.setVerticalBias(view.getId(), 0f);
        
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // Das bewirkt die Animation!!! :)
                TransitionManager.beginDelayedTransition(constraintLayout);
                //TransitionManager.beginDelayedTransition(constraintLayout,new ChangeBounds().setDuration(1000));
            }
            

        constraintSet.applyTo(constraintLayout);
    }
}

// Ueberschiessende Animation:
////////////////////////////////////////////////////////////////////////
Transition transition = new ChangeBounds()
        .setDuration(3000)
      //.setInterpolator(new AnticipateOvershootInterpolator(1.0f))
        .setInterpolator(new OvershootInterpolator(1.0f));
////////////////////////////////////////////////////////////////////////

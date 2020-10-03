
// Simple//////////////////////////////////////////////////////////////////
public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet = new ConstraintSet();


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id in activity_main selber gesetzt :)
        constraintLayout = findViewById(R.id.activity_main);

        // Das macht die ganze Logik! B)
        constraintSet.clone(this, R.layout.activity_main_end);
        ------------------------------------------------------
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick_button(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);

        constraintSet.applyTo(constraintLayout);
    }
}


//Complex//////////////////////////////////////////////////////////////////
public class MainActivity extends AppCompatActivity {
    
	private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet_new;
    private ConstraintSet constraintSet_old;
    private boolean wechsel = true;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.activity_main);
        constraintSet_new = new ConstraintSet();
        constraintSet_old = new ConstraintSet();

        constraintSet_new.clone(this, R.layout.activity_main_end);
        constraintSet_old.clone(constraintLayout);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick_button(View view) {

        TransitionManager.beginDelayedTransition(constraintLayout);

        if (wechsel) {
            constraintSet_new.applyTo(constraintLayout);
            wechsel = false;
        } else {
            constraintSet_old.applyTo(constraintLayout);
            wechsel = true;
        }
    }
}


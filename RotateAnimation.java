public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private View view_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick_imageview(View view) {
        view_ = view;
        RotateAnimation animation = new RotateAnimation(0f, -45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(0);
        animation.setDuration(250);
        // Wichtig für Aufruf:  public void onAnimationEnd(Animation animation)
        animation.setAnimationListener(this);

        view.startAnimation(animation);
    }


    // region 'Animation.AnimationListener' 3 x Interface Methods!
    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        RotateAnimation animation1 = new RotateAnimation(-45f, 45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation1.setRepeatMode(Animation.REVERSE);
        animation1.setRepeatCount(10);
        animation1.setDuration(500);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                RotateAnimation animation2 = new RotateAnimation(45f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation2.setRepeatMode(Animation.REVERSE);
                animation2.setDuration(250);
                view_.startAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        findViewById(R.id.imageView1).startAnimation(animation1);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
    // endregion
}
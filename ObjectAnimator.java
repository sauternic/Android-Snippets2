public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick_imageview(View view) {
        final View view_ = view;

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0f, -45f);
        objectAnimator.setDuration(250);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {

                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view_, "rotation", -45f, 45f);
                objectAnimator2.setDuration(500);
                objectAnimator2.setRepeatMode(objectAnimator2.REVERSE);
                objectAnimator2.setRepeatCount(7);
                objectAnimator2.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(view_, "rotation", -45f, 0f);
                        objectAnimator3.setDuration(250);
                        objectAnimator3.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                objectAnimator2.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        objectAnimator.start();

    }

}

  /*rotation
    rotationX
    rotationY
    translationX
    translationY
    scaleX
    scaleY
    pivotX
    pivotY
    alpha
    x
    y*/
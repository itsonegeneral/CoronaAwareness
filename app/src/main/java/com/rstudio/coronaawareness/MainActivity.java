package com.rstudio.coronaawareness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    int i = 0; //Dummy variable for switching the animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing views
        final LottieAnimationView lottieView = findViewById(R.id.lottieView);
        final TextView textView = findViewById(R.id.tvTextView);
        lottieView.playAnimation(); //starting the animation
        lottieView.loop(true); //setting loop will keep the animation playing

        //used for doing something after the animation is loaded
        lottieView.postOnAnimation(new Runnable() {
            @Override
            public void run() {
            }
        });


        //Using a timer to change between those animations
        CountDownTimer timer = new CountDownTimer(200000,5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (i % 2 == 0) { //This can also be replaced with millisUntilFinished but its not precise

                    //Setting animation 1 and changing text
                    lottieView.setAnimation(R.raw.hygene);
                    textView.setText("Stay safe!");
                    lottieView.loop(true);
                    lottieView.playAnimation();
                }else{

                    //Setting animation 2 and changing text
                    lottieView.setAnimation(R.raw.wash);
                    lottieView.loop(true);
                    lottieView.playAnimation();
                    textView.setText("Always wash your hands with soap!");
                }
                i++;
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();


    }
}

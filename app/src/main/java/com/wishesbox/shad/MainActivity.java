package com.wishesbox.shad;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {


    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottieAnimationView);
        startCheckAnimation();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ScreenActivity.class);
                startActivity(intent);
                finish();

            }
        }, 3000);

    }
    private void startCheckAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f).setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setProgress((float) animation.getAnimatedValue());
            }
        });
        if (lottieAnimationView.getProgress() == 0f) {
            animator.start();
        } else {
            lottieAnimationView.setProgress(0f);
        }
    }
}




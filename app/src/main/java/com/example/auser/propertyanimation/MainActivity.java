package com.example.auser.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);
        playFrameAnimationFromXML();
        playFrameAnimation();
    }

    void playAnimation(){

        ObjectAnimator oaRotate = ObjectAnimator.ofFloat(img, "rotation", 0 ,360);
        oaRotate.setDuration(1000);
        oaRotate.setRepeatCount(5);
        oaRotate.setRepeatMode(ObjectAnimator.REVERSE);
        oaRotate.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

                Toast.makeText(MainActivity.this, "第一段動畫結束", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator oaForward = ObjectAnimator.ofFloat(img, "x" , 0 , 400);
        oaForward.setDuration(3000);
        oaForward.setRepeatCount(ObjectAnimator.INFINITE);
        oaForward.setRepeatMode(ObjectAnimator.REVERSE);

        AnimatorSet as = new AnimatorSet();
        as.playSequentially(oaRotate,oaForward);
        as.start();
    }

    void playFrameAnimation(){
        anim = (AnimationDrawable) img.getBackground();
        anim.start();
    }

    void playFrameAnimationFromXML(){
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.animator);
        set.setTarget(img);
        set.start();
    }
}

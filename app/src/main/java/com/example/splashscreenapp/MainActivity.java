package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation top_animation,bottom_animation ,left_animation,right_animation,rotate_animation;
    public static final int  SPLASH_ACTIVITY=9000;
    ImageView schoolBoy1,schoolBoy2;
    TextView MainLogo,SmallLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        top_animation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        rotate_animation= AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        left_animation= AnimationUtils.loadAnimation(this,R.anim.left_animation);
        right_animation= AnimationUtils.loadAnimation(this,R.anim.right_animation);

        schoolBoy1=findViewById(R.id.schoolBoy1);
        schoolBoy2=findViewById(R.id.schoolBoy2);
        MainLogo=findViewById(R.id.MainLogo);
        SmallLogo=findViewById(R.id.SmallLogo);
        schoolBoy1.setAnimation(top_animation);
        schoolBoy2.setAnimation(bottom_animation);
        MainLogo.setAnimation(rotate_animation);
        SmallLogo.setAnimation(right_animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(schoolBoy1,"logo_schoolboy1");
                pairs[1]=new Pair<View,String>(MainLogo,"logo_theme");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                //startActivity(new Intent(MainActivity.this,LoginActivity.class));
             Intent intent=   new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent,options.toBundle());
                finish();
            }
        }, SPLASH_ACTIVITY);
    }
}

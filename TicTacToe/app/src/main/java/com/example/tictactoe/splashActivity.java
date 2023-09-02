package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.logo);

        Animation Alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        imageView.setAnimation(Alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(splashActivity.this, MainActivity.class);
                startActivity(splash);
                finish();
            }
        },2000);
    }
}
package com.example.simplifiedcoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (SharedPrefManager.getInstance(splash.this).isLoggedIn()) {
                    finish();
                    startActivity(new Intent(splash.this, ProfileActivity.class));
                    return;
                } else {
                    finish();
                    startActivity(new Intent(splash.this, MainActivity.class));
                    return;
                }

            }
        }, 2000);



    }
}
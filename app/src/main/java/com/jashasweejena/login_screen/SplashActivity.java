package com.jashasweejena.login_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hanks.htextview.base.HTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Button mLoginBtn;
    Button mRegisterBtn;
    HTextView helloTxtView;
    String[] listOfWords;
    int i = 0;
    boolean isComplete = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        listOfWords = new String[]{"ନମସ୍କାର,", "নমস্কার", "नमस्ते,", "வணக்கம்,", "నమస్కారం,", "Hola,", "Bonjour,", "Hello !"};

        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        helloTxtView = (com.hanks.htextview.evaporate.EvaporateTextView) findViewById(R.id.hellotxtview);
        mLoginBtn = findViewById(R.id.loginbtn);
        mRegisterBtn = findViewById(R.id.registerbtn);

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                helloTxtView.animateText(listOfWords[i++]);

                if(i < listOfWords.length - 1) {
                    h.postDelayed(this, 1000);
                    Log.d("Runnable", "run: " + listOfWords[i]);
                    Log.d("RunnabBool", "run: " + isComplete);
                }
            }
        }, 200);


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();

    }
}

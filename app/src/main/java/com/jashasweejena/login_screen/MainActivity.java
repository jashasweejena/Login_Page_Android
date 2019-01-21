package com.jashasweejena.login_screen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView mLogo;
    HTextView wcomeTxtView;
    HTextView signTxtView;
    String[] listOfWords;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listOfWords = new String[]{"Namaskar,", "Namaste,", "Hola,", "Bonjour,", "Nǐ hǎo,"};
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        wcomeTxtView = (com.hanks.htextview.evaporate.EvaporateTextView) findViewById(R.id.textView2);
        signTxtView = (com.hanks.htextview.evaporate.EvaporateTextView) findViewById(R.id.textView);
        wcomeTxtView.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(HTextView hTextView) {

            }
        });
        signTxtView.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(HTextView hTextView) {

            }
        });

       final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                wcomeTxtView.animateText(listOfWords[i++]);

                if(i < listOfWords.length - 1) {
                    h.postDelayed(this, 1000);
                    Log.d("Runnable", "run: " + listOfWords[i]);
                }
            }
        }, 200);
        mLogo = findViewById(R.id.logo_imgview);
        mLogo.setImageResource(R.drawable.logo_dark);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

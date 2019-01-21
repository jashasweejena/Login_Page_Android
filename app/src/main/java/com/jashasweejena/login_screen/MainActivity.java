package com.jashasweejena.login_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView mLogo;
    HTextView wcomeTxtView;
    HTextView signTxtView;
    Switch mSwitch;
    String[] listOfWords;
    int i = 0;
    boolean isComplete = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.darktheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogo = findViewById(R.id.logo_imgview);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            mLogo.setImageResource(R.drawable.logo_dark);
        }
        else{
            mLogo.setImageResource(R.drawable.logo_light);

        }
        mSwitch = findViewById(R.id.mySwitch);

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            mSwitch.setChecked(true);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                   darkMode();
                }
                else{
                    lightMode();
                }
            }
        });
        listOfWords = new String[]{"ନମସ୍କାର,", "নমস্কার", "नमस्ते,", "வணக்கம்,", "నమస్కారం,", "Hola,", "Bonjour,", "Hello !"};
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        wcomeTxtView = (com.hanks.htextview.evaporate.EvaporateTextView) findViewById(R.id.textView2);
        signTxtView = (com.hanks.htextview.evaporate.EvaporateTextView) findViewById(R.id.textView);

       final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                wcomeTxtView.animateText(listOfWords[i++]);

                if(i < listOfWords.length - 1) {
                    h.postDelayed(this, 1000);
                    Log.d("Runnable", "run: " + listOfWords[i]);
                    Log.d("RunnableBool", "run: " + isComplete);
                }
                if(i == listOfWords.length - 1)
                    signTxtView.animateText("Sign in to continue!");
            }
        }, 200);

        mLogo = findViewById(R.id.logo_imgview);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void restartApp(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    public void darkMode(){
        mLogo.setImageResource(R.drawable.logo_light);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        restartApp();
    }
    public void lightMode(){
        mLogo.setImageResource(R.drawable.logo_dark);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        restartApp();
    }
}

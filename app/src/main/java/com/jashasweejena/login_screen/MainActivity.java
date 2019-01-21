package com.jashasweejena.login_screen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hanks.htextview.base.HTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView mLogo;
    HTextView wcomeTxtView;
    HTextView signTxtView;
    String[] listOfWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listOfWords = new String[]{"Namaskar,", "Namaste,", "Hola,", "Nǐ hǎo,", "Bonjour,"};
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        wcomeTxtView = (HTextView) findViewById(R.id.textView2);
        signTxtView = (HTextView) findViewById(R.id.textView);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(String x : listOfWords){
            wcomeTxtView.animateText(x);
        }
        mLogo = findViewById(R.id.logo_imgview);
        mLogo.setImageResource(R.drawable.logo_dark);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

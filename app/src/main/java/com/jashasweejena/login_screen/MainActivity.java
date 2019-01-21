package com.jashasweejena.login_screen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;

public class MainActivity extends AppCompatActivity {
    ImageView mLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        final HTextView textView = (HTextView) findViewById(R.id.textView2);
        final Handler h = new Handler();
        h.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                textView.animateText("Welcome back");
                if(i == 1){ // just remove call backs
                    h.removeCallbacks(this);
                    Log.d("Runnable","ok");
                } else { // post again
                    i++;
                    h.postDelayed(this, 1000);
                }
            }
        });
        mLogo = findViewById(R.id.logo_imgview);
        mLogo.setImageResource(R.drawable.logo_dark);

    }
}

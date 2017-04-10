package com.example.innisa.solitaireproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class scrnSplash extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scrn_splash);
//    }

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        @Override
        public void run() {
            closeSplash();
            //handler.postDelayed(runnable, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrn_splash);

        playmp3();

        handler.postDelayed(runnable,5000);


    }

    //play an pm3 sound
    public void playmp3(){
       // MediaPlayer countdown = MediaPlayer.create(this,R.raw.countdown);
       // countdown.start();
    }
    private void closeSplash() {
        Intent intent = new Intent(this, scrnGame.class);
        startActivity(intent);
    }
}

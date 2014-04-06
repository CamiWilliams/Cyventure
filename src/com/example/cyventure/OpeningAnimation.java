package com.example.cyventure;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OpeningAnimation extends Activity {

	private TextView text1;
	private TextView text2;
	private TextView text3;
	private ImageView myImageView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.animation);

        MediaPlayer song = MediaPlayer.create(this, R.raw.splashmusic);
        song.start();
        text1 = (TextView) findViewById(R.id.anima1);
        text2 = (TextView) findViewById(R.id.anima2);
        text3 = (TextView) findViewById(R.id.anima3);
        myImageView= (ImageView)findViewById(R.id.imageView);
        
        text1.setText("Presenting");
        text1.setVisibility(4);
        text2.setText("a Team 20 creation");
        text2.setVisibility(4);
        text3.setText("Cyventure");
        text3.setVisibility(4);
        myImageView.setVisibility(4);
    
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
            	final Animation in1 = new AlphaAnimation(0.0f, 1.0f);
		        in1.setDuration(3000);
		        text1.startAnimation(in1);
		        text1.setVisibility(0);
		        final Animation out1 = new AlphaAnimation(1.0f, 0.0f);
		        out1.setDuration(3000);
		        text1.startAnimation(out1);
		        text1.setVisibility(4);
            }
        }, 4000);
        
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
            	final Animation in2 = new AlphaAnimation(0.0f, 1.0f);
		        in2.setDuration(3000);
		        text2.startAnimation(in2);
		        text2.setVisibility(0);
		        
		        final Animation out2 = new AlphaAnimation(1.0f, 0.0f);
		        out2.setDuration(3000);
		        text2.startAnimation(out2);
		        text2.setVisibility(4);
		        
            }
        }, 9000);
        
        final Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
            	final Animation in3 = new AlphaAnimation(0.0f, 1.0f);
		        in3.setDuration(3000);
		        myImageView.startAnimation(in3);
		        myImageView.setVisibility(0);
		        
		        final Animation out3 = new AlphaAnimation(1.0f, 0.0f);
		        out3.setDuration(3000);
		        myImageView.startAnimation(out3);
		        myImageView.setVisibility(4);
		        
            }
        }, 13000);
			
        final Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
        		startActivity(i);
		        
            }
        }, 16000);
		

	}
}

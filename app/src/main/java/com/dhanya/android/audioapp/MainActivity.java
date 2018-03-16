package com.dhanya.android.audioapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_btn = (Button) findViewById(R.id.play_btn);
        play_btn.setOnClickListener(this);
        Button pause_btn = (Button) findViewById(R.id.pause_btn);
        pause_btn.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.family_daughter);
        switch (v.getId())
        {
            case R.id.play_btn: mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast toast = Toast.makeText(getApplicationContext(),"I 'm done",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                break;
            case R.id.pause_btn: mediaPlayer.pause();
                                break;
            default:
                Log.v(this.getLocalClassName(), "Not working");

        }



    }

    
}

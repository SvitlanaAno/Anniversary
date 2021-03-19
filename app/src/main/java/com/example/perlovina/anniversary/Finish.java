package com.example.perlovina.anniversary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by perlovina on 7/15/18.
 */

class Finish extends AppCompatActivity {
    public static final String LOG_TAG = Finish.class.getSimpleName();
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        TextView textMain = (TextView)findViewById(R.id.text_main);
        textMain.setText("Wubba lubba dub dub!\n" +
                "Ты прошел все уровни и получил нужные тебе данные. " +
                "Впиши все коды в правильном порядке и узнай местонахождение подарка!\n" +
                "Кстати, твоя Заварнуха ЛЮБИТ ТЕБЯ!)");
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.rick9);


        EditText inputName = (EditText) findViewById(R.id.text_input);
        inputName.setVisibility(View.GONE);
        final Button buttonCheck = (Button)findViewById(R.id.button_check);
        buttonCheck.setVisibility(View.GONE);
        mediaPlayer = MediaPlayer.create(this, R.raw.song3);
        // Start the audio file
        mediaPlayer.start();

        // Setup a listener on the media player, so that we can stop and release the
        // media player once the sound has finished playing.
        mediaPlayer.setOnCompletionListener(onComletionListener);

    }

    private MediaPlayer.OnCompletionListener onComletionListener =  new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing it's resources.
     */
    private void releaseMediaPlayer() {
        // If the MediaPlayer is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}

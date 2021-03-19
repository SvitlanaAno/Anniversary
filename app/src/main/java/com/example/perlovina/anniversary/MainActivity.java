package com.example.perlovina.anniversary;
import android.content.Intent;
import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.perlovina.anniversary.FirstQuest;
import com.example.perlovina.anniversary.R;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textMain = (TextView)findViewById(R.id.text_main);
        textMain.setText("Здравствуйте, Вано! Глядя на дату на календаре, сегодня исполняется ровно 2 года с того момента, как ты совершил ошибку))\n" +
                "Ты конечно же знаешь, что я считаю что сама идея обмена подарками абсолютно бессмысленна, так как это крайне трудоёмкое занятие, так как мне нужно думать, что же тебе подарить , в то время когда только ты знаешь, что тебе нужно. Исходя из этого, ты не увидишь моего подарка, потому что я тебе его не покупал.\n" +
                "Но твой бегемот считает, что это обязательный социальный обычай и поздравляет тебя с сегодняшним днём. Она приготовила тебе сюрприз, который ты сможешь найти, разгадав все мои задания. Все, на что ты можешь рассчитывать - это твои силы.\n" +
                "Крепись чувак!");
        Button button = (Button)findViewById(R.id.button_intent);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstQuest.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.song1);
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

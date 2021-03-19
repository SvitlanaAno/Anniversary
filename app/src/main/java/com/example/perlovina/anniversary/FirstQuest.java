package com.example.perlovina.anniversary;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by perlovina on 7/14/18.
 */

public class FirstQuest extends AppCompatActivity {
    /** Tag for the log messages */
    public static final String LOG_TAG = FirstQuest.class.getSimpleName();
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        final TextView textMain = (TextView)findViewById(R.id.text_main);
        textMain.setText("Первое задание, которое с лёгкостью решит любой даже Морти:\n" +
                "Посчитай количество ступенек в своем подъезде. Считай не спеша и не ошибись, иначе придётся пересчитывать." +
                " После того как посчитаешь, умножь это число на количество лет проведенных вместе с твоей грациозной ланью)) " +
                "Полученный код – это ключ для перехода на второй уровень.\n");

        final TextView textAnswer = (TextView)findViewById(R.id.text_answer);

        final EditText inputName = (EditText) findViewById(R.id.text_input);

        final Button buttonCheck = (Button)findViewById(R.id.button_check);

        final Button button = (Button)findViewById(R.id.button_intent);
        button.setVisibility(View.GONE);

        buttonCheck.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int input = 0;
                try{
                    input = Integer.parseInt(inputName.getText().toString());
                }catch(NumberFormatException ex){
                    // handle  exception
                    Log.e(LOG_TAG, "error with edit number occur");
                }

                if(input != 128){
                    Random random = new Random();
                    String phrase[] = {"Лошок попробук еще разок",
                            "Хаха! не угадал говнюк",
                            "Жить — значит рисковать всем. В противном случае ты просто вялая кучка " +
                                    "беспорядочно собранных молекул, плывущих по течению Вселенной. Не угалад короч ",
                            "Хочешь слышать приятные слова? Встречайся с лингвистом! Не угадал, говнюк",
                            "Своими мозгами думай, не будь тупым стадом.",
                            "Ты выглядишь какой-то тряпкой, соберись!" };
                    int pos = random.nextInt(phrase.length);
                    textAnswer.setText(phrase[pos]);
                }
                else {
                    textMain.setText("Ееееее! " +
                            "Красавчик, но помни, дальше будет посложнее!\n" +
                            "Впиши буквы в бланк, это тебе пригодится потом:\n" +
                            "3-г; 5-я; 11-м; 14-ю; 17-р; 20-у\n");
                    textAnswer.setText("");
                    button.setVisibility(View.VISIBLE);
                    buttonCheck.setVisibility(View.GONE);
                    inputName.setVisibility(View.GONE);
                }
            }
        });

        // Register the onClick listener with the implementation above
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstQuest.this, SecondQuest.class);
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

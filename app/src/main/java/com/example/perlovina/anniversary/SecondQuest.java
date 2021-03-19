package com.example.perlovina.anniversary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by perlovina on 7/14/18.
 */

class SecondQuest extends AppCompatActivity {
    /** Tag for the log messages */
    public static final String LOG_TAG = SecondQuest.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        final TextView textMain = (TextView)findViewById(R.id.text_main);
        textMain.setText("Следующая часть кода – в записке, которую хранят стальные кони, \n" +
                "что всю жизнь в погоне. \n");


        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.rick3);

        final TextView textAnswer = (TextView)findViewById(R.id.text_answer);

        EditText inputName = (EditText) findViewById(R.id.text_input);
        inputName.setVisibility(View.GONE);

        final Button buttonCheck = (Button)findViewById(R.id.button_check);

        buttonCheck.setVisibility(View.GONE);
        final Button button = (Button)findViewById(R.id.button_intent);
        button.setVisibility(View.VISIBLE);

        // Register the onClick listener with the implementation above
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondQuest.this, Third.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }

}

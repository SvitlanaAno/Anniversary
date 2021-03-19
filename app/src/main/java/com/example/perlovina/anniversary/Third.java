package com.example.perlovina.anniversary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by perlovina on 7/15/18.
 */

class Third extends AppCompatActivity {
    public static final String LOG_TAG = Third.class.getSimpleName();
    int clickcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        final TextView textMain = (TextView)findViewById(R.id.text_main);
        textMain.setText("Я рад, что ты продолжаешь бороться. Этот уровень, как я и обещал, будет посложнее. " +
                "Тебе нужно найти подсказку, точнее записку, спрятанную где-то в квартире." +
                " Я дам тебе несколько наводок, которые помогут тебе узнать, где она спрятана, точнее в каком предмете." +
                " Подсказки я буду тебе писать, когда ты будешь вводить неправильный ответ\n");

        final TextView textAnswer = (TextView)findViewById(R.id.text_answer);

        final EditText inputName = (EditText) findViewById(R.id.text_input);
        inputName.setInputType(InputType.TYPE_CLASS_TEXT);

        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.rick5);

        final Button buttonCheck = (Button)findViewById(R.id.button_check);

        final Button button = (Button)findViewById(R.id.button_intent);
        button.setVisibility(View.GONE);

        buttonCheck.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String input = "";
                try{
                    input = inputName.getText().toString();
                }catch(NumberFormatException ex){
                    // handle  exception
                    Log.e(LOG_TAG, "error with edit text occur");
                }

                if(!input.contentEquals("туалетная бумага")){
                    String phrase[] = {"Люди, проживающие в прибрежных районах, очень часто использовали для своих нужд раковины мидий." +
                            "Жители Гавайских островов пользовались скорлупой от кокосовых орехов. \n" +
                            "А мы пользуемся этим",
                            "Когда сидишь в раздумьях и ноги затекают ты используешь это",
                            "Без неё в хозяйстве трудно,\n" +
                            "Некомфортно, неуютно.\n" +
                            "Эта вещь нужна тебе, мягкая и нежная и сначала свежая",
                            "Первые американские переселенцы, использовали кукурузные кочерыжки. А мы уже использеум ее"
                    };
                    if(clickcount< phrase.length) {
                        textAnswer.setText(phrase[clickcount]);
                        clickcount = clickcount + 1;
                    }
                }
                else {
                    textMain.setText("Да, не ожидал я что этот уровень окажется тебе по плечу!" +
                            " Вписывай буквы с подсказки дальше в бланк.");
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
                Intent intent = new Intent(Third.this, FourthQuest.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}

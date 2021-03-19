package com.example.perlovina.anniversary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

class FourthQuest extends AppCompatActivity {
    public static final String LOG_TAG = FourthQuest.class.getSimpleName();
    int clickcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        final TextView textMain = (TextView)findViewById(R.id.text_main);
        textMain.setText("Вау! Твое стремление позволило дойти тебе до этого уровня. " +
                "Хотя я очень сомневаюсь, что ты его осилишь говнюк. Наверное сейчас ты спрашиваешь себя «Почему?»\n" +
                " Да потому что код, который ты должен получить, отправлен на автоответчик бегемоту. " +
                "Есть номер телефона, где ты можешь узнать но просто так я его тебе не дам. Тебе придётся отгадать его.\n");

        final TextView textAnswer = (TextView)findViewById(R.id.text_answer);

        final EditText inputName = (EditText) findViewById(R.id.text_input);

        inputName.setVisibility(View.GONE);
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.rick6);

        final Button buttonCheck = (Button)findViewById(R.id.button_check);

        final Button button = (Button)findViewById(R.id.button_intent);
        button.setVisibility(View.GONE);


        buttonCheck.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                    String phrase[] = {"- первые 4 цифры - Основание Кембриджского университета.",
                            "- следующие три цифры - номер модели автомобиля бизнес-класса выпускавшийся под маркой " +
                            "Peugeot с 1999 по 2009",
                            "- последние 4 цифры 8211"
                    };
                if(clickcount< phrase.length) {
                    textAnswer.setText(phrase[clickcount]);
                    clickcount = clickcount + 1;
                }
                else {
                    textMain.setText("Позвони по полученому номеру и введи пин код (дата и месяц начала отношений)");
                    textAnswer.setText("");
                    button.setVisibility(View.VISIBLE);
                    buttonCheck.setVisibility(View.GONE);

                }
            }
        });

        // Register the onClick listener with the implementation above
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthQuest.this, Finish.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}

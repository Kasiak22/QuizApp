package com.example.android.myquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {
    int score=0;
    RadioButton an1;
    RadioButton an2;
    RadioGroup quest1;
    RadioGroup quest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        Button btn2 = (Button) findViewById(R.id.move_button);
        btn2.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                move(v);
            }
        });

        an1 = findViewById(R.id.b1_radio_button);
        an2 = findViewById(R.id.b2_radio_button);
        quest1 = findViewById(R.id.quest1);
        quest2 = findViewById(R.id.quest2);

    }


    public void next(){if (an1.isChecked()){score++;}
        if (an2.isChecked()){score++;}
        Intent myIntent2 = new Intent(QuizActivity.this, Quiz2Activity.class);
        myIntent2.putExtra("score", score);
        startActivity(myIntent2);
                }


    public void move(View v) {
        if (quest1.getCheckedRadioButtonId() == -1 || quest2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, R.string.ans, Toast.LENGTH_LONG).show();

        } else
        {next();
        finish();}
    }


}

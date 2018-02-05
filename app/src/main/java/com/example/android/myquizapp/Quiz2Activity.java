package com.example.android.myquizapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class Quiz2Activity extends AppCompatActivity {
    int score;
    CheckBox a3;
    CheckBox b3;
    CheckBox c3;
    CheckBox d3;
    CheckBox a4;
    CheckBox b4;
    CheckBox c4;
    CheckBox d4;
    String ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz2);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");


        a3 = findViewById(R.id.a3_checkbox);
        b3 = findViewById(R.id.b3_checkbox);
        c3 = findViewById(R.id.c3_checkbox);
        d3 = findViewById(R.id.d3_checkbox);

        a4 = findViewById(R.id.a4_checkbox);
        b4 = findViewById(R.id.b4_checkbox);
        c4 = findViewById(R.id.c4_checkbox);
        d4 = findViewById(R.id.d4_checkbox);


    }

    public void sc_edit() {
        EditText read = findViewById(R.id.ed_answer);
        ans = read.getText().toString();
    }


    public void sc_check() {
        if (a3.isChecked() && c3.isChecked() && !b3.isChecked() && !d3.isChecked()) {
            score++;
        }
        if (a4.isChecked() && b4.isChecked() && c4.isChecked() && !d4.isChecked()) {
            score++;
        }
        if (ans.equalsIgnoreCase(getResources().getString(R.string.ans_ed))) {
            score++;
        }


    }


    public void toast(View v) {
        sc_edit();
        if (!a3.isChecked() && !c3.isChecked() && !b3.isChecked() && !d3.isChecked() || !a4.isChecked() && !b4.isChecked() && !c4.isChecked() && !d4.isChecked() || ans.equals("")) {
            Toast.makeText(this, R.string.ans, Toast.LENGTH_LONG).show();
        } else {
            sc_check();
            Intent myIntent2 = new Intent(Quiz2Activity.this, Submit.class);
            myIntent2.putExtra("score", score);
            startActivity(myIntent2);
            finish();


        }

    }
}

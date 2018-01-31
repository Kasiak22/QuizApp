package com.example.android.myquizapp;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.start);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                start();
            }
        });
    }

    public void start() {
        Intent myIntent = new Intent(MainActivity.this, QuizActivity.class);
        startActivity(myIntent);
    }


}
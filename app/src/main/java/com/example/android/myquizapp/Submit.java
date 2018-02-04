package com.example.android.myquizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Submit extends AppCompatActivity {
    int score;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");

        if (score <= 2) {
            message = String.format(getString(R.string.mes_p2a), score);
        }
        if (score > 2 && score <= 4) {
            message = String.format(getString(R.string.mes_p2b),score  );
        }
        if (score == 5) {
              message = String.format(getString(R.string.mes_p2c), score  );

        }

        TextView orderSummaryTextView = findViewById(R.id.summary);
        orderSummaryTextView.setText(message);

        Button btn1 = (Button) findViewById(R.id.share_button);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                share(v);
            }
        });
        Button btn2 = (Button) findViewById(R.id.try_button);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trya(v);
            }
        });
        Button btn3 = (Button) findViewById(R.id.learn_button);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {
                    learn (v);
                }
            }
        });

    }

    public void share(View v) {
        String message = String.format(getString(R.string.mail),score);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(share, getString(R.string.mail_title)));
    }

    public void trya(View v) {
        Intent myIntent2 = new Intent(Submit.this, MainActivity.class);
        startActivity(myIntent2);
    }

    public void learn(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cancer.gov"));
        startActivity(browserIntent);

    }


}








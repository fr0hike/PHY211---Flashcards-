package com.computerauthority.phy211_flashcards;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View v;
    private int counter = 0;
    private Button tx;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        removeActionBar();
        v = findViewById(R.id.root);
        tx = (Button) findViewById(R.id.btn);





        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (counter){
                    case 0: // ? --> 1
                        tx.setText("1");
                        v.setBackgroundColor(Color.parseColor("#f47a42"));
                        break;
                    case 1: // 1 --> 2
                        tx.setText("2");
                        v.setBackgroundColor(Color.parseColor("#fff719"));
                        break;
                    case 2: // 2 --> 3
                        tx.setText("3");
                        v.setBackgroundColor(Color.parseColor("#02b6f7"));
                        break;
                    case 3: // 3 --> 4
                        tx.setText("4");
                        v.setBackgroundColor(Color.parseColor("#ffffff"));
                        break;
                    case 4: // 4 --> 5
                        tx.setText("5");
                        v.setBackgroundColor(Color.parseColor("#2fce4f"));
                        break;
                    case 5: // 5 --> 6
                        tx.setText("6");
                        v.setBackgroundColor(Color.parseColor("#ce2f64"));
                        break;
                    case 6:
                        tx.setText("?");
                        v.setBackgroundColor(Color.parseColor("#cf16fe"));
                        counter = -1;
                        break;
                }

                counter++;

            }
        });
    }


    private void removeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }



}

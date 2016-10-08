package com.computerauthority.phy211_flashcards;

import android.content.res.Configuration;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.OrientationListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View v;
    private View vL;
    private View vR;
    private int counter = 0;
    private int counterL = 0;
    private int counterR = 0;
    private Button tx;
    private Button left;
    private Button right;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            counter = 0;
            setContentView(R.layout.activity_main);
            v = findViewById(R.id.root);
            tx = (Button) findViewById(R.id.btn);
            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = screenSet(v,tx,counter);

                }
            });
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            counterL = 0;
            counterR = 0;
            setContentView(R.layout.landscape_mode);
            vL = findViewById(R.id.left_layout);
            vR = findViewById(R.id.right_layout);

            left = (Button) findViewById(R.id.btn_l);
            right = (Button) findViewById(R.id.btn_r);

            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counterL = screenSet(vL,left,counterL);
                }
            });

            right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counterR = screenSet(vR,right,counterR);
                }
            });
        }
        removeActionBar();




    }


    private int screenSet(View view, Button b,int counter) {
        switch (counter) {
            case 0: // ? --> 1
                b.setText("1");
                view.setBackgroundColor(Color.parseColor("#f47a42"));
                break;
            case 1: // 1 --> 2
                b.setText("2");
                view.setBackgroundColor(Color.parseColor("#fff719"));
                break;
            case 2: // 2 --> 3
                b.setText("3");
                view.setBackgroundColor(Color.parseColor("#02b6f7"));
                break;
            case 3: // 3 --> 4
                b.setText("4");
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                break;
            case 4: // 4 --> 5
                b.setText("5");
                view.setBackgroundColor(Color.parseColor("#2fce4f"));
                break;
            case 5: // 5 --> 6
                b.setText("6");
                view.setBackgroundColor(Color.parseColor("#ce2f64"));
                break;
            case 6:
                b.setText("?");
                view.setBackgroundColor(Color.parseColor("#cf16fe"));
                counter = -1;
                break;
        }
        counter++;
        return counter;
    }

    private void removeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }


}

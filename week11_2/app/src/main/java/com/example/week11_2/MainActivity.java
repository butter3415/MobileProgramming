package com.example.week11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonstart, buttonstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonstart = (Button) findViewById(R.id.start);
        buttonstop = (Button) findViewById(R.id.stop);

        buttonstart.setOnClickListener(this);
        buttonstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.start){
            // start
            startService(new Intent(this, MyService.class));
        } else {
            // stop
            stopService(new Intent(this, MyService.class));
        }
    }
}
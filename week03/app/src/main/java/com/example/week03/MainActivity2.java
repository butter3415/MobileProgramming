package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(this);

        Intent intent = getIntent();
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("ID : " + intent.getStringExtra("id")
        + ",\n PASSWORD : " + intent.getStringExtra("pw"));


        Log.d("inha","ID : " + intent.getStringExtra("id")
                + "\n PASSWORD : " + intent.getStringExtra("pw"));

        Log.d("inha_SubActivity","onCreate");

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
        Log.d("inha_SubActivity","onClick");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("inha_SubActivity","onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("inha_SubActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("inha_SubActivity","onResume");
    }


}
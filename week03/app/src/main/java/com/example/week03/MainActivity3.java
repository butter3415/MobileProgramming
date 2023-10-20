package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.d("inha_MainActivity3","onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("inha_MainActivity3","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("inha_MainActivity3","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("inha_MainActivity3","onPause");
    }
}
package com.example.week03;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etID;
    EditText etPW;

    Button button;

    Button buttonplayasset;
    Button buttonplayraw;
    Button buttonstop;
    AssetFileDescriptor descriptor;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonplayasset);
        button.setOnClickListener(this);

        Log.d("inha_MainActivity","onCreate");

        TextView tv = (TextView) findViewById(R.id.tvtest);
        // 객체 갖고옴

        tv.setText("LOGIN");

        etID = (EditText) findViewById(R.id.editTextText);
        etPW = (EditText) findViewById(R.id.editTextTextPassword);

        Button btn = (Button) findViewById(R.id.buttonplayasset);

        btn.setOnClickListener(this);

        buttonplayasset = (Button) findViewById(R.id.buttonplayasset);
        buttonplayraw = (Button) findViewById(R.id.buttonplayraw);
        buttonstop = (Button) findViewById(R.id.buttonplaystop);

        buttonplayasset.setOnClickListener(this);
        buttonplayraw.setOnClickListener(this);
        buttonstop.setOnClickListener(this);

        AssetManager am = getAssets();
        try{
            descriptor = am.openFd("just_dance.mp3");

        } catch (IOException e){
            Log.e(TAG, "IOException : " +e.toString());
            e.printStackTrace();
        }
    }

    // MainActivity
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.buttonplayasset){
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
                        descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e){
                e.printStackTrace();
            }
        }else if (view.getId() == R.id.buttonplayraw){
            mediaPlayer = MediaPlayer.create(this, R.raw.just_dance);
            mediaPlayer.start();
        }else {
            if(mediaPlayer != null) mediaPlayer.stop();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("inha_MainActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("inha_MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("inha_MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("inha_MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("inha_MainActivity","onDestroy");
    }
}
package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    ProgressBar pb;

    Button buttoninc, buttondec;

    TextView tvSeek;

    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);

        buttoninc = (Button) findViewById(R.id.buttonInc);
        buttoninc.setOnClickListener(this);

        buttondec = (Button) findViewById(R.id.buttonDec);
        buttondec.setOnClickListener(this);

        tvSeek = (TextView) findViewById(R.id.tvSeek);

        seekbar = (SeekBar) findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonInc){
            // button Inc
            pb.incrementProgressBy(10);
        } else {
            // buutton dec
            pb.incrementProgressBy(-10);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tvSeek.setText("진행률 : " + i + "%");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
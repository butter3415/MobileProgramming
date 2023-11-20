package com.example.week10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SeekBar pb1, pb2;

    Button btn;

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = (SeekBar) findViewById(R.id.pb1);
        pb2 = (SeekBar) findViewById(R.id.pb2);

        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

    }



    @Override
    public void onClick(View view) {
//        for (int i = 0; i < 100; i++){
//            pb1.setProgress(pb1.getProgress()+2);
//            pb2.setProgress(pb2.getProgress()+1);
//            SystemClock.sleep(100);
//        }

        new Thread(){
            public void run(){
                for(int i = 0; i < 100; i++){
                    /*
                    pb1.setProgress(pb1.getProgress()+2);
                    tv1.setText("1번 진행률 : " + pb1.getProgress() + "%");
                    */

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pb1.setProgress(pb1.getProgress()+2);
                            tv1.setText("1번 진행률 : " + pb1.getProgress() + "%");
                        }
                    });

                    SystemClock.sleep(100);
                }
            }
        }.start();

        new Thread(){
            public void run(){
                for(int i = 0; i < 100; i++){
//                    pb2.setProgress(pb2.getProgress()+1);
//                    tv2.setText("2번 진행률 : " + pb2.getProgress() + "%");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pb2.setProgress(pb2.getProgress()+1);
                            tv2.setText("2번 진행률 : " + pb2.getProgress() + "%");
                        }
                    });

                    SystemClock.sleep(100);
                }
            }
        }.start();

    }
}
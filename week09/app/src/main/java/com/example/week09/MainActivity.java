package com.example.week09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sharedPref = null;

    EditText editText;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button  = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        sharedPref = getSharedPreferences("Android", Context.MODE_PRIVATE);
        if(sharedPref != null){ // 값이 없으면 빈 스트링 리턴해~
            editText.setText(sharedPref.getString("Name",""));
        }

    }


    @Override
    public void onClick(View view) {
        if (sharedPref != null){
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("Name", editText.getText().toString());
            editor.commit();

        }
    }
}
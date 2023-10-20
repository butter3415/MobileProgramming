package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    CheckBox checkBox;
    RadioButton option1, option2, option3;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(this);

        option1 = (RadioButton) findViewById(R.id.radioButton1);
        option1.setOnClickListener(this);

        option2 = (RadioButton) findViewById(R.id.radioButton2);
        option2.setOnClickListener(this);

        option3 = (RadioButton) findViewById(R.id.radioButton3);
        option3.setOnClickListener(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        // spinner.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        if(id == R.id.checkBox) {
            if (checkBox.isChecked()) {
                // checked
                Toast.makeText(this, "checked", Toast.LENGTH_SHORT).show();
            } else {
                // unchecked
                Toast.makeText(this, "unchecked", Toast.LENGTH_SHORT).show();
            }
        } else if(id == R.id.radioButton1){
            // radio1
            Toast.makeText(this, "Option1", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.radioButton2){
            // radio2
            Toast.makeText(this, "Option2", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.radioButton3){
            // radio3
            Toast.makeText(this, "Option3", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Position : " + i + ", " +
                "Value : " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Position : " + i + ", " +
                "Value : " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
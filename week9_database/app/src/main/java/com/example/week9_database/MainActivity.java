package com.example.week9_database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase sqLiteDB = null;

    EditText id, name, phone;

    TextView result;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.editTextID);
        name = (EditText) findViewById(R.id.editTextName);
        phone = (EditText) findViewById(R.id.editTextPhone);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        result = (TextView) findViewById(R.id.textViewResult);

        try{
            sqLiteDB = openOrCreateDatabase("sample.db", MODE_PRIVATE, null);
        } catch (SQLiteException e){
            e.printStackTrace();
        }

        if(sqLiteDB != null){
            String sqlCreateTable =
                    "CREATE TABLE IF NOT EXISTS CONTACT_T(ID INTEGER NOT NULL, NAME TEXT, PHONE TEXT)";
            sqLiteDB.execSQL(sqlCreateTable);
        }
    }

    @Override
    public void onClick(View view) {
        String sqlInsert = "INSERT INTO CONTACT_T (ID, NAME, PHONE) " +
                "VALUES('" + id.getText().toString() + "', '" + name.getText().toString() + "' ,'" + phone.getText().toString() + "' )";

        Log.d("TEST", "insert sql = " + sqlInsert);

        sqLiteDB.execSQL(sqlInsert);

        String sqlSelect = "SELECT * FROM CONTACT_T";

        Cursor cursor = null;   // 데이터 위치 가리킴
        cursor = sqLiteDB.rawQuery(sqlSelect, null);

        String tableResult = "";

        while(cursor.moveToNext()){
            tableResult += cursor.getInt(0)+", " + cursor.getString(1) + ", " + cursor.getString(2) + "\n";
            // 0번째 인덱스(첫번째) ID, 1번째 인덱스(두번째) NAME, 2번째 인덱스(세번째) PHONE
        }

        result.setText(tableResult);

    }
}
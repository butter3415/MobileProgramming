package com.example.week06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView listView;

    // String[] tv = {"무빙", "마스크걸", "오징어게임","카지노","유퀴즈","나는솔로","나혼자산다","최강야구"};
    // String[] tv;    // array.xml 에 선언해줘서 변경

    ArrayList<String> tv;

    ArrayAdapter<String> adapter;

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        editText = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        tv = new ArrayList<String>();

        // tv = getResources().getStringArray(R.array.tv); // array.xml 선언해줘서 변경
        // adapter 위에 선언해줘야 tv가 null이 안됨

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tv);
        // adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, tv);  // 라디오버튼
        // listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setAdapter(adapter);
        

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // Toast.makeText(this, tv[i],Toast.LENGTH_SHORT).show();  // show 꼭 붙여줘야함(Toast)

        // ArrayList로 사용할때
        Toast.makeText(this, tv.get(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        tv.add(editText.getText().toString());
        adapter.notifyDataSetChanged(); // 데이터가 바꼈어! -> 알려줌

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        tv.remove(i);
        adapter.notifyDataSetChanged();
        return false;
    }
}
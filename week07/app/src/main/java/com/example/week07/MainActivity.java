package com.example.week07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        boolean ret = isExternalStorageWritable();
//        Toast.makeText(this, "isExternalStorageWritable : " + ret, Toast.LENGTH_SHORT).show();
//        // 결과를 토스트로 보여주기

//        WebView webView = (WebView) findViewById(R.id.webView);
//        webView.loadUrl("https://m.naver.com"); // http (x) -> https (o)

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    public static boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        // 권한이 획득되었는지 확인하는 코드
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permissionCheck == PackageManager.PERMISSION_DENIED){
            // 권한 없음
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            // 물어보기꺄지 가능


        } else {
            // 권한 있음
            Toast.makeText(this, "권한 있음", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Pixel 6 API 28 로 실행해야 제대로 보임
        if(requestCode == 0){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "권한 획득", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "권한 없음", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver wifistateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifistate = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            if(wifistate == WifiManager.WIFI_STATE_ENABLED){
                Log.d("TEST", "WIFI_STATE_ENABLED");
            } else if(wifistate == WifiManager.WIFI_STATE_DISABLED){
                Log.d("TEST","WIFI_STATE-_DISABLED");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.registerReceiver(this.wifistateReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(this.wifistateReceiver);
    }
}
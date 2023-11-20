package com.example.week12_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectThread extends Thread{
    public String strUrl;

    public ConnectThread(String url){
        this.strUrl = url;
    }

    private String request(String strUrl){
        StringBuilder output = new StringBuilder();

        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if(conn != null){
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                int resCode = conn.getResponseCode();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while (true){
                    line = reader.readLine();
                    if(line == null) break;
                    output.append(line + "\n");
                }
                reader.close();
                conn.disconnect();

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return output.toString();
    }

    public void run(){
        final String output = request(this.strUrl);

        MainActivity.handler.post(new Runnable() {
            @Override
            public void run() {
                MainActivity.textView.setText(output);
            }
        });
    }

}

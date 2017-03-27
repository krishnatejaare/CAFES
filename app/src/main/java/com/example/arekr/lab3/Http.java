package com.example.arekr.lab3;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {

    public String read(String httpUrl) throws IOException {
        String httpData = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
       // try {
            URL url = new URL(httpUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection.getResponseCode());
            //httpURLConnection.setRequestMethod("GET");
            //httpURLConnection.setDoOutput(false);
            // httpURLConnection.application/json
            httpURLConnection.connect();
            System.out.println(httpURLConnection.getResponseCode());

            inputStream = httpURLConnection.getInputStream();
            System.out.println(httpURLConnection.getResponseCode());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            httpData = stringBuffer.toString();
            System.out.println("YAMAHA");
            System.out.println(httpData);
            bufferedReader.close();
        //} catch (Exception e) {
          //  Log.d("Exception - reading Http url", e.toString());
        //} finally {
            inputStream.close();
            httpURLConnection.disconnect();
       // }

        return httpData;
    }
}
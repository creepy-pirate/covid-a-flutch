package com.example.covid_a_fluch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Query extends AppCompatActivity {
    public static int sum=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query);
        sum=0;
    }
  public void plusOne(View view){
        sum=sum+1;
        view.setPadding(100,0,0,0);
    }
    public void plusthree(View view){
        sum=sum+3;
        view.setPadding(100,0,0,0);
    }
    public void plusfive(View view){
        sum=sum+5;
        view.setPadding(100,0,0,0);
    }

    public void Submitted(View view) {
        Intent i =new Intent(this,Result.class);
        startActivity(i);
    }
}
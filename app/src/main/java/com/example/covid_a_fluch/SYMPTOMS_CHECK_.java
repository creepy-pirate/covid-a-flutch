package com.example.covid_a_fluch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SYMPTOMS_CHECK_ extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptoms_check);

    }

    public void AGREE(View view) {
        Intent i =new Intent(this,Query.class);
        startActivity(i);
    }
}

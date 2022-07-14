package com.example.covid_a_fluch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void WORLD_STATS(View view){
        Intent i =new Intent(this,WORLD_STATS.class);
        startActivity(i);
    }
    public void VACCINATION(View view){
        Intent i =new Intent(this,VACCINATION.class);
        startActivity(i);
    }
    public void CONTAINMENT_ZONE(View view){
        Intent i =new Intent(this, SYMPTOMS_CHECK_.class);
        startActivity(i);
    }
    public void GOVERNMENT_AID(View view){
        Intent i =new Intent(this,GOVERNMENT_AID.class);
        startActivity(i);
    }
}
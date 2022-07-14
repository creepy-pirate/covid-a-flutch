package com.example.covid_a_fluch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class donate extends AppCompatActivity {

    LinearLayout L;
    TextView T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);
    }
    public void pmnrf(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pmnrf.gov.in/en/online-donation/"));
        startActivity(browserIntent);
    }
}
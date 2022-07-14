package com.example.covid_a_fluch;

import android.content.Intent;
import android.net.Uri;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

import androidx.appcompat.app.AppCompatActivity;




public class GOVERNMENT_AID extends AppCompatActivity {

    EditText tname,tage,tgender,taccount,tifsc,tbank;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.government_aid);

        tname = (EditText) findViewById(R.id.name);
        tage = (EditText) findViewById(R.id.age);
        tgender = (EditText) findViewById(R.id.spinner_gender);
        taccount = (EditText) findViewById(R.id.bank);
        tifsc = (EditText) findViewById(R.id.account);
        tbank = (EditText) findViewById(R.id.ifsc);

    }
    public void DONATE(View view) {
        String name = tname.getText().toString();
        String age = tage.getText().toString();
        String gender = tgender.getText().toString();
        String account = taccount.getText().toString();
        String ifsc = tifsc.getText().toString();
        String bankname = tbank.getText().toString();
        Context context = getApplicationContext();
        try {
            FileOutputStream fos = openFileOutput("donation.txt", MODE_APPEND );
            String b = name + "|" + age + "|" + gender + "|" + account + "|" + bankname + "|" + ifsc + "$\n";
            fos.write(b.getBytes());
            fos.close();
            Toast.makeText(getApplicationContext(),"WROTE TO FILE: DONATION",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Intent i =new Intent(this,donate.class);
        startActivity(i);
    }
    public void COI(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hindustantimes.com/india-news/centre-announces-measures-for-families-who-lost-earning-members-to-covid-19-all-you-need-to-know-101622353307945.html"));
        startActivity(browserIntent);
    }
    public void BOI(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.livemint.com/news/india/bihar-announces-compensation-of-rs-4-lakh-to-kin-of-those-who-died-due-to-covid-11623202462449.html"));
        startActivity(browserIntent);
    }
}

package com.example.covid_a_fluch;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    LinearLayout L;
    TextView T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        L = findViewById(R.id.LinearLayout);
        T = findViewById(R.id.TextView);
        if(Query.sum <= 7)
        {
            L.setBackgroundColor(R.id.COVIDSHIELD);
            T.setText("You are having mild symptoms and can manage your symptoms at home. Try to maintain distance with your fammily members and call your doctor immediately whenever feeling uneasy. Your symptoms should get cured within 5-7 days");
        }

        else if(Query.sum <= 20)
        {
            L.setBackgroundColor(R.id.COVAXIN);
            T.setText("You are having medium symptoms and you can either take care at home or refer to your nearby clinic. Try to maintain distance with your fammily members and call your doctor immediately whenever feeling uneasy. Even when the conditions get slightly worse rush to your nearby hospital asap");
        }
    }
}

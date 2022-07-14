package com.example.covid_a_fluch;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class VACCINATION extends AppCompatActivity {
    private static final String USGS_REQUEST_URL =
            "https://timesofindia.indiatimes.com/life-style/health-fitness/health-news/coronavirus-vaccination-covishield-covaxin-sputnik-v-or-moderna-which-vaccine-may-be-a-better-choice";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccination);


        PieChart pieChart = new PieChart(this);
        TextView Covaxin = findViewById(R.id.COVAXIN);
        TextView CovidShield = findViewById(R.id.COVIDSHIELD);
        TextView Sputnik = findViewById(R.id.SPUTNIK);
        TextView Moderna = findViewById(R.id.MODERNA);
        pieChart = findViewById(R.id.piechart);


        pieChart.addPieSlice(
                new PieModel(
                        "COVAXIN",
                        50,
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "COVIDSHIELD",
                        30,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "SPUTNIK",
                        15,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "MODERNA",
                        5,
                        Color.parseColor("#29B6F6")));

    }
    public void TOI(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://timesofindia.indiatimes.com/india/frequently-asked-questions-about-serums-covishield-vaccine/articleshow/83167882.cms/"));
        startActivity(browserIntent);
    }
    public void GOI(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mygov.in/covid-19/"));
        startActivity(browserIntent);
    }

    public void RELATE1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mpnrc.org/covaxin-vs-covishield/"));
        startActivity(browserIntent);
    }

    public void RELATE1Y(View view) {
        Intent browserIntentY = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=klJ-1XK071k"));
        startActivity(browserIntentY);
    }

    public void RELATE2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mayoclinic.org/coronavirus-covid-19/vaccine-side-effects"));
        startActivity(browserIntent);
    }

    public void RELATE2Y(View view) {
        Intent browserIntentY = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xn0pRq84j_M"));
        startActivity(browserIntentY);
    }

    public void RELATE3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.businessinsider.in/science/news/one-chart-shows-how-well-covid-19-vaccines-protect-you-against-the-delta-variant/articleshow/85465849.cms"));
        startActivity(browserIntent);
    }

    public void RELATE3Y(View view) {
        Intent browserIntentY = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/S_SJZBJgcog"));
        startActivity(browserIntentY);
    }
    public void BOOKNOW(View view) {
        Intent browserIntentY = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cowin.gov.in/"));
        startActivity(browserIntentY);
    }
}

package com.example.covid_a_fluch;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

public class WORLD_STATS extends AppCompatActivity {
    int data[] = new int[7];
    private static final String REQUEST_URL =
            "https://api.rootnet.in/covid19-in/stats/latest";

    TextView tCases, tDischarged, tConfirmedCases, tvConfirmedCasesForeign, tDeaths;
    EditText tState;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);
        tCases = (TextView) findViewById(R.id.tCases);
        tDischarged = findViewById(R.id.tDischarged);
        tConfirmedCases = findViewById(R.id.tConfirmedCases);
        tvConfirmedCasesForeign = findViewById(R.id.tConfirmedCasesForeign);
        tDeaths = findViewById(R.id.tDeaths);


        StatsAsyncTask task = new StatsAsyncTask();
        task.execute(REQUEST_URL);


    }


    private class StatsAsyncTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... urls) {


            URL url = null;
            try {
                url = new URL(urls[0]);
            } catch (MalformedURLException e) {
                Log.e("QueryUtils", "Problem building the URL ", e);
            }

            String jsonResponse = null;
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                Log.e("WORLD_STATS", "Problem making the HTTP request.", e);
            }


            try {
                JSONObject baseJsonResponse = new JSONObject(jsonResponse);

                JSONObject Data = baseJsonResponse.getJSONObject("data");
                JSONObject Summary = Data.getJSONObject("summary");
                data[0] = Summary.getInt("total");
                data[1] = Summary.getInt("discharged");
                data[2] = Summary.getInt("deaths");
                data[3] = Summary.getInt("confirmedCasesIndian");
                data[4] = Summary.getInt("confirmedCasesForeign");


            } catch (JSONException e) {
                // If an error is thrown when executing any of the above statements in the "try" block,
                // catch the exception here, so the app doesn't crash. Print a log message
                // with the message from the exception.
                Log.e("WORLD_STATS", "Problem parsing the earthquake JSON results", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            tCases.setText(String.valueOf(data[0]));
            tDischarged.setText(String.valueOf(data[1]));
            tDeaths.setText(String.valueOf(data[2]));
            tConfirmedCases.setText(String.valueOf(data[3]));
            tvConfirmedCasesForeign.setText(String.valueOf(data[4]));

        }
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("QueryUtils", "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("QueryUtils", "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}


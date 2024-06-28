package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnSR, btnFR, btnSGR, btnFCR, btnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSR = findViewById(R.id.btnSR);
        btnFR = findViewById(R.id.btnFR);
        btnSGR = findViewById(R.id.btnSGR);
        btnFCR = findViewById(R.id.btnFCR);
        btnChart = findViewById(R.id.btnChart);


        btnSR.setOnClickListener(v -> {
            Intent intent = new Intent(this, SRActivity.class);
            startActivity(intent);
        });

        btnFR.setOnClickListener(v -> {
            Intent intent = new Intent(this, FRActivity.class);
            startActivity(intent);
        });

        btnSGR.setOnClickListener(v -> {
            Intent intent = new Intent(this, SGRActivity.class);
            startActivity(intent);
        });

        btnFCR.setOnClickListener(v -> {
            Intent intent = new Intent(this, FCRActivity.class);
            startActivity(intent);
        });

        btnChart.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChartActivity.class);
            startActivity(intent);
        });

    }
}
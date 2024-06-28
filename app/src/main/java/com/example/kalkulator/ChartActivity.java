package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ChartActivity extends AppCompatActivity {
    private WebView webViewChart, webViewTambah, webViewData;
    private Button btnShowWebViewTambah, btnShowWebViewData;
    private boolean webViewTambahVisible = false; // Status WebView tambahan
    private boolean webViewDataVisible = false; // Status WebView data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chart);

        webViewChart = findViewById(R.id.webViewChart);
        webViewTambah = findViewById(R.id.webViewTambah);
        webViewData = findViewById(R.id.webViewData);
        btnShowWebViewTambah = findViewById(R.id.btnShowWebViewTambah);
        btnShowWebViewData = findViewById(R.id.btnShowWebViewData); // Menambahkan inisialisasi btnShowWebViewData

        // Mengaktifkan JavaScript di WebView
        WebSettings webSettingsChart = webViewChart.getSettings();
        WebSettings webSettingsTambah = webViewTambah.getSettings();
        WebSettings webSettingsData = webViewData.getSettings();
        webSettingsChart.setJavaScriptEnabled(true);
        webSettingsTambah.setJavaScriptEnabled(true);
        webSettingsData.setJavaScriptEnabled(true);

        // Memuat file HTML lokal atau URL eksternal untuk WebView utama
        webViewChart.loadUrl("http://10.153.174.96/kalkulator/index.php"); // Ubah sesuai dengan lokasi file HTML Anda

        // Atur onClickListener untuk tombol yang akan menampilkan WebView Tambahan
        btnShowWebViewTambah.setOnClickListener(v -> {
            if (!webViewTambahVisible) {
                webViewTambah.setVisibility(View.VISIBLE); // Tampilkan WebView Tambahan
                webViewTambah.loadUrl("http://10.153.174.96/kalkulator/index2.php"); // Load URL untuk WebView Tambahan
                webViewTambahVisible = true; // Set status WebView Tambahan menjadi terlihat
            } else {
                webViewTambah.setVisibility(View.GONE); // Sembunyikan WebView Tambahan
                webViewTambahVisible = false; // Set status WebView Tambahan menjadi tidak terlihat
            }
        });

        // Atur onClickListener untuk tombol yang akan menampilkan WebView Data
        btnShowWebViewData.setOnClickListener(v -> {
            if (!webViewDataVisible) {
                webViewData.setVisibility(View.VISIBLE); // Tampilkan WebView Data
                webViewData.loadUrl("http://10.153.174.96/kalkulator/tampildata.php"); // Load URL untuk WebView Data
                webViewDataVisible = true; // Set status WebView Data menjadi terlihat
            } else {
                webViewData.setVisibility(View.GONE); // Sembunyikan WebView Data
                webViewDataVisible = false; // Set status WebView Data menjadi tidak terlihat
            }
        });
    }
}
